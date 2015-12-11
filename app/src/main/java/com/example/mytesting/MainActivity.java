package com.example.mytesting;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pojo.TblKredit;


public class MainActivity extends ActionBarActivity implements OnClickListener {
    Button btnPost;
    EditText edNoKredit;
    EditText resNoKredit, resNamaNasabah, resUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPost = (Button) findViewById(R.id.btnPost);
        btnPost.setOnClickListener(this);

        edNoKredit = (EditText) findViewById(R.id.edNoKredit);
        edNoKredit.setError(null);
        resNoKredit = (EditText) findViewById(R.id.resNoKredit);
        resNamaNasabah = (EditText) findViewById(R.id.resNamaNasabah);
        resUp = (EditText) findViewById(R.id.resUp);

    }

    @Override
    public void onClick(View view) {
        System.out.println(" ON CLIK CLIK GET ");
        String textNoKredit = edNoKredit.getText().toString().trim();

        if (textNoKredit.length()>0) {
            System.out.println(" ON CLIK CLIK GET --- Valid");
            new SendGetHttpBack().execute();
        } else {
            edNoKredit.setError("Wajib diisi!!!");
            Toast.makeText(MainActivity.this, "Wajib Diisi!!", Toast.LENGTH_LONG).show();
            System.out.println(" ON CLIK CLIK GET --- Invalid ");
            return;
        }

//        System.out.println(" ON CLIK CLIK {POST ");
//        new SendPostHttpBack().execute(); // Tinggal Aktifin saja
    }

    private void hideKeyboard() {

        InputMethodManager inputManager = (InputMethodManager) MainActivity.this
                .getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(
                MainActivity.this.getCurrentFocus()
                        .getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }


    private class SendGetHttpBack extends AsyncTask<String, Void, TblKredit> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            hideKeyboard();
        }

        @Override
        protected TblKredit doInBackground(String[] params) {
            GadaiRestClient gdRestClient = new GadaiRestClient();
            TblKredit kredit = gdRestClient.InquiryKreditByNomor(edNoKredit.getText().toString());
            return kredit;
        }

        @Override
        protected void onPostExecute(TblKredit kredit) {
            if (kredit != null) {
//                System.out.println("DATA KREDIT" + kredit.toString());
                System.out.println("No Kredit : " + kredit.getNoKredit());
                System.out.println("Nama Nasabah : " + kredit.getCustomerName());
                System.out.println("UP : " + kredit.getUp().doubleValue());

                resNoKredit.setText(kredit.getNoKredit());
                resNamaNasabah.setText(kredit.getCustomerName());
                resUp.setText(String.valueOf(kredit.getUp().doubleValue()));
            } else {
                System.out.println(" Response OK --- no kredit tidak ditemukan");
                Toast.makeText(MainActivity.this, "No kredit tidak ditemukan", Toast.LENGTH_LONG).show();
            }
        }
    }

    private class SendPostHttpBack extends AsyncTask<String, Void, GadaiResponse> {
        @Override
        protected GadaiResponse doInBackground(String[] params) {
            GadaiRestClient gdRestClient = new GadaiRestClient();
            GadaiRequest payReq = new GadaiRequest();
            payReq.setNoKredit("1");
            payReq.setUserName("syaiful");
            payReq.setBranchCode("13439");
            payReq.setJenisTransaksi("GU");
            GadaiResponse response = gdRestClient.paymentGadaiUlang(
                    payReq.getNoKredit(), payReq.getUserName( ), payReq.getBranchCode(), payReq.getJenisTransaksi());

            return response;
        }

        @Override
        protected void onPostExecute(GadaiResponse response) {
            if (response != null) {
                System.out.println("Ref ID" + response.getRefId());
                System.out.println("Kode Transaksi" + response.getTransactionCode());
                System.out.println("ID Transaksi" + response.getTransactionNo());
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
