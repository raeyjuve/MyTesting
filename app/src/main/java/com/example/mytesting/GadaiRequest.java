package com.example.mytesting;

/**
 * Created by syaiful on 30/03/2015.
 */
public class GadaiRequest {
    private String userName;
    private String branchCode;
    private String noKredit;
    private String jenisTransaksi;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getNoKredit() {
        return noKredit;
    }

    public void setNoKredit(String noKredit) {
        this.noKredit = noKredit;
    }

    public String getJenisTransaksi() {
        return jenisTransaksi;
    }

    public void setJenisTransaksi(String jenisTransaksi) {
        this.jenisTransaksi = jenisTransaksi;
    }
}
