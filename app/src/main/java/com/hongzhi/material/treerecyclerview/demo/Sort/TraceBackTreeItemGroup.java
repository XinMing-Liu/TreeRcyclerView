package com.hongzhi.material.treerecyclerview.demo.Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author XinMing-Liu
 * @create 2019/5/28 16:24
 */
public class TraceBackTreeItemGroup {
    private String barcode="";//"16010200051711030003",
    private String rawmaterialscode="";//"16010100381711020030",
    private String materialscode="";//"1601010038",
    private String materialsname="";//"大拉光面丝",
    private String materialsspecificatione="";//"1.30ht",
    private String proc="";//"大拉",
    private String workshopname="";//"三车间",
    private List<TraceBackTreelItem> neighbours=new ArrayList<>();//

    public TraceBackTreeItemGroup(String barcode,
                                  String rawmaterialscode,
                                  String materialscode,
                                  String materialsname,
                                  String materialsspecificatione,
                                  String proc,
                                  String workshopname,
                                  List<TraceBackTreelItem> neighbours) {
        this.barcode = barcode;
        this.rawmaterialscode = rawmaterialscode;
        this.materialscode = materialscode;
        this.materialsname = materialsname;
        this.materialsspecificatione = materialsspecificatione;
        this.proc = proc;
        this.workshopname = workshopname;
        this.neighbours = neighbours;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getRawmaterialscode() {
        return rawmaterialscode;
    }

    public void setRawmaterialscode(String rawmaterialscode) {
        this.rawmaterialscode = rawmaterialscode;
    }

    public String getMaterialscode() {
        return materialscode;
    }

    public void setMaterialscode(String materialscode) {
        this.materialscode = materialscode;
    }

    public String getMaterialsname() {
        return materialsname;
    }

    public void setMaterialsname(String materialsname) {
        this.materialsname = materialsname;
    }

    public String getMaterialsspecificatione() {
        return materialsspecificatione;
    }

    public void setMaterialsspecificatione(String materialsspecificatione) {
        this.materialsspecificatione = materialsspecificatione;
    }

    public String getProc() {
        return proc;
    }

    public void setProc(String proc) {
        this.proc = proc;
    }

    public String getWorkshopname() {
        return workshopname;
    }

    public void setWorkshopname(String workshopname) {
        this.workshopname = workshopname;
    }

    public List<TraceBackTreelItem> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<TraceBackTreelItem> neighbours) {
        this.neighbours = neighbours;
    }

}
