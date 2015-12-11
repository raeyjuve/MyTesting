package com.example.mytesting;

import com.example.pojo.TblKredit;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * Created by syaiful on 30/03/2015.
 */
public class GadaiRestClient {
//    private String server = "http://10.0.2.2:8080";
    private String server = "http://10.2.21.110:8080";
    RestTemplate restClient;

    public GadaiRestClient() {
        restClient = new RestTemplate();
        restClient.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
        restClient.getMessageConverters().add(new StringHttpMessageConverter());
    }

    public TblKredit InquiryKreditByNomor(String noKredit) {
        String url = "/inquiry/gadai/";
//        String dataKredit = restClient.getForObject(server + url + noKredit, String.class);
//        System.out.println("DATA HASIL INQUIRY :" + dataKredit);
        ResponseEntity<TblKredit> hasilKredit = restClient.getForEntity(server + url + noKredit, TblKredit.class);
        TblKredit kredit = hasilKredit.getBody();
        return kredit;
    }

    public GadaiResponse paymentGadaiUlang(String noKredit, String userName, String branchCode, String jenisTransaksi) {
        GadaiRequest payReq = new GadaiRequest();
        payReq.setNoKredit(noKredit);
        payReq.setUserName(userName);
        payReq.setBranchCode(branchCode);
        payReq.setJenisTransaksi(jenisTransaksi);
        String url = "/payment/gadai";
        URI uriLokasi = restClient.postForLocation(server + url, payReq);
        System.out.println("URI Response" + uriLokasi);
        GadaiResponse resp = restClient.getForObject(uriLokasi, GadaiResponse.class);

        System.out.println("DATA HASIL RESPONE :" + resp.toString());
        return resp;
    }

}
