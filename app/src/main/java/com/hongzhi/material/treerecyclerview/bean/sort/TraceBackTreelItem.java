package com.hongzhi.material.treerecyclerview.bean.sort;

/**
 * @Author XinMing-Liu
 * @create 2019/5/28 16:25
 */
public class TraceBackTreelItem {


    private String barcode="";//"16010200051711020051",
    private String rawmaterialscode="";//"16010100381711020031",
    private String materialscode="";//"1601010038",
    private String materialsname="";//"大拉光面丝",
    private String materialsspecificatione="";//"1.30ht",
    private String proc="";//"大拉",
    private String workshopname="";//"三车间"

    public TraceBackTreelItem(String barcode,
                              String rawmaterialscode,
                              String materialscode,
                              String materialsname,
                              String materialsspecificatione,
                              String proc,
                              String workshopname) {
        this.barcode = barcode;
        this.rawmaterialscode = rawmaterialscode;
        this.materialscode = materialscode;
        this.materialsname = materialsname;
        this.materialsspecificatione = materialsspecificatione;
        this.proc = proc;
        this.workshopname = workshopname;
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
}
