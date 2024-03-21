package ru.rosniivh.swr.dto.report;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.rosniivh.swr.dto.filter.BasinFilterForUser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BasinFilterForUserReport {
    HashMap<Integer, Data> heParcel;
    HashMap <Integer, Data> subBasin;
    HashMap <Integer, Data> riverBasin;
    HashMap <Integer, Data> basinDistrict;
    HashMap <Integer, Data> rfSubject;
    HashMap <Integer, Data> fdSubject;

    public BasinFilterForUserReport(List<BasinFilterForUser> array, List<BasinFilterForUser> array0) {
        this.heParcel = new HashMap<>();
        this.subBasin = new HashMap<>();
        this.riverBasin = new HashMap<>();
        this.basinDistrict = new HashMap<>();
        this.fdSubject = new HashMap<>();
        this.rfSubject = new HashMap<>();
        for (BasinFilterForUser item : array) {
            if (this.basinDistrict.get(item.getUidDistrict()) != null) {
                this.basinDistrict.get(item.getUidDistrict()).addParent(item.getUidRiver());
            } else {
                this.basinDistrict.put(item.getUidDistrict(), new Data(item.getUidDistrict(), item.getCodeDistrict(), item.getNameDistrict(), item.getUidRiver()));
            }
            if (this.riverBasin.get(item.getUidRiver()) != null) {
                this.riverBasin.get(item.getUidRiver()).addParent(item.getUidSubBasin());
            } else {
                this.riverBasin.put(item.getUidRiver(), new Data(item.getUidRiver(), item.getCodeRiver(), item.getNameRiver(), item.getUidSubBasin()));
            }
            if (this.subBasin.get(item.getUidSubBasin()) != null) {
                this.subBasin.get(item.getUidSubBasin()).addParent(item.getUidHeParcel());
            } else {
                this.subBasin.put(item.getUidSubBasin(), new Data(item.getUidSubBasin(), item.getCodeSubBasin(), item.getNameSubBasin(), item.getUidHeParcel()));
            }
            this.heParcel.put(item.getUidHeParcel(), new Data(item.getUidHeParcel(), item.getCodeHeParcel(), item.getNameHeParcel(), null));
        }
        for (BasinFilterForUser item : array0) {
            if (this.fdSubject.get(item.getUidFd()) != null) {
                this.fdSubject.get(item.getUidFd()).addParent(item.getUidRf());
            } else {
                this.fdSubject.put(item.getUidFd(), new Data(item.getUidFd(), "", item.getFederalDistrict(), item.getUidRf()));
            }
            this.rfSubject.put(item.getUidRf(), new Data(item.getUidRf(), item.getConstNumber(), item.getNameRf(), null));
        }
    }
}

class Data {
    private Integer uid;
    private String code;
    private String name;
    private List<Integer> parent;

    public Data(Integer uid, String code, String name, Integer parent) {
        this.uid = uid;
        this.code = code;
        this.name = name;
        this.parent = new ArrayList<>();
        this.parent.add(parent);
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getParent() {
        return parent;
    }

    public void setParent(List<Integer> parent) {
        this.parent = parent;
    }

    public void addParent(Integer parent){
        for(Integer item : this.parent){
            if(item == parent)
                return;
        }
        this.parent.add(parent);
    }
}