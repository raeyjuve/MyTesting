package com.example.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by syaiful on 30/03/2015.
 */
public class TblKredit {
    private String noAplikasi;
    private String noKredit;
    private String productCode;
    private String branchCode;
    private Date tglKredit;
    private String customerName;
    private Date tglJatuhTempo;
    private Date tglLelang;
    private BigDecimal up;
    private BigDecimal sewaModal;
    private BigDecimal admin;
    private String status;
    private String tenor;
    private Date tglTransaksi;
    private String jenisTransaksi;

    public String getNoAplikasi() {
        return noAplikasi;
    }

    public void setNoAplikasi(String noAplikasi) {
        this.noAplikasi = noAplikasi;
    }

    public String getNoKredit() {
        return noKredit;
    }

    public void setNoKredit(String noKredit) {
        this.noKredit = noKredit;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public Date getTglKredit() {
        return tglKredit;
    }

    public void setTglKredit(Date tglKredit) {
        this.tglKredit = tglKredit;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getTglJatuhTempo() {
        return tglJatuhTempo;
    }

    public void setTglJatuhTempo(Date tglJatuhTempo) {
        this.tglJatuhTempo = tglJatuhTempo;
    }

    public Date getTglLelang() {
        return tglLelang;
    }

    public void setTglLelang(Date tglLelang) {
        this.tglLelang = tglLelang;
    }

    public BigDecimal getUp() {
        return up;
    }

    public void setUp(BigDecimal up) {
        this.up = up;
    }

    public BigDecimal getSewaModal() {
        return sewaModal;
    }

    public void setSewaModal(BigDecimal sewaModal) {
        this.sewaModal = sewaModal;
    }

    public BigDecimal getAdmin() {
        return admin;
    }

    public void setAdmin(BigDecimal admin) {
        this.admin = admin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTenor() {
        return tenor;
    }

    public void setTenor(String tenor) {
        this.tenor = tenor;
    }

    public Date getTglTransaksi() {
        return tglTransaksi;
    }

    public void setTglTransaksi(Date tglTransaksi) {
        this.tglTransaksi = tglTransaksi;
    }

    public String getJenisTransaksi() {
        return jenisTransaksi;
    }

    public void setJenisTransaksi(String jenisTransaksi) {
        this.jenisTransaksi = jenisTransaksi;
    }
}
