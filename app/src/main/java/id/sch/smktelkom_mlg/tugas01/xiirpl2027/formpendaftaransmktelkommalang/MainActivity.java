package id.sch.smktelkom_mlg.tugas01.xiirpl2027.formpendaftaransmktelkommalang;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;


@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity {

    EditText etnama, etgolrah, ettl;
    RadioGroup status, jeniskelamin;
    RadioButton menikah, belum_menikah, laki, perempuan;
    Spinner spkecamatan, spkelurahan;
    String[][] arkelurahan =
     {
            {
                    ""
            },
            {
                    "Sentul","Ngadirejo","Tanggung","Bendo","Kauman","Kepanjen Kidul","Kepanjen Lor"
            },
            {
                    "Bendogerit","Plosokerep","Rembang","Klampok","Gedog","Karang Tengah","Sanan Wetan"
            },
            {
                    "Sukorejo","Pakunden","Tlumpu","Karang Sari","Blitar","TanjungSari","Turi"
            }
    };

    ArrayList<String> listkelurahan = new ArrayList<>();
    ArrayAdapter<String> adapter;
    CheckBox  kristen, konghuchu, islam, katholik, budha;
    TextView hnama, hgolrah, htl, hstatus, hkecamatan, tstatus;
    EditText etno, etalamat, etagama;
    TextView hno, halamat, hjk, hagama;
    Button buttonOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etno = (EditText) findViewById(R.id.no);
        etalamat = (EditText) findViewById(R.id.Alamat);
        etagama = (EditText) findViewById(R.id.Agama);
        etnama = (EditText) findViewById(R.id.nama);
        etgolrah = (EditText) findViewById(R.id.Golrah);
        ettl = (EditText) findViewById(R.id.TL);
        laki = (RadioButton) findViewById(R.id.laki);
        perempuan = (RadioButton) findViewById(R.id.perempuan);
        menikah = (RadioButton) findViewById(R.id.menikah);
        belum_menikah = (RadioButton) findViewById(R.id.belum_menikah);
        tstatus = (TextView) findViewById(R.id.textViewStatus);
        status = (RadioGroup) findViewById(R.id.jurussan);
        islam = (CheckBox) findViewById(R.id.checkBoxIslam);
        kristen = (CheckBox) findViewById(R.id.checkBoxKristen);
        konghuchu = (CheckBox) findViewById(R.id.checkBoxKonghuchu);
        budha = (CheckBox) findViewById(R.id.checkBoxBudha);
        katholik = (CheckBox) findViewById(R.id.checkBoxKatholik);
        hnama = (TextView) findViewById(R.id.hnama);
        hno = (TextView) findViewById(R.id.hno);
        halamat = (TextView) findViewById(R.id.halamat);
        hagama = (TextView) findViewById(R.id.hagama);
        hgolrah = (TextView) findViewById(R.id.hgolrah);
        htl = (TextView) findViewById(R.id.htl);
        hstatus = (TextView) findViewById(R.id.hstatus);
        hkecamatan = (TextView) findViewById(R.id.hkecamatan);
        hjk = (TextView) findViewById(R.id.hjeniskelamin);
        hagama = (TextView) findViewById(R.id.hagama);
        buttonOK = (Button) findViewById(R.id.buttonDaftar);
        spkecamatan = (Spinner) findViewById(R.id.spinnerkecamatan);
        spkelurahan = (Spinner) findViewById(R.id.spinnerkelurahan);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listkelurahan);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spkelurahan.setAdapter(adapter);

        spkecamatan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                listkelurahan.clear();
                listkelurahan.addAll(Arrays.asList(arkelurahan[pos]));
                adapter.notifyDataSetChanged();
                spkelurahan.setSelection(0);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        findViewById(R.id.buttonDaftar).setOnClickListener(new View.OnClickListener() {
                                                               @Override
                                                               public void onClick(View view) {
                                                                   doClick();
                                                               }

                                                               private void doClick() {
                                                                   if (isValid()) {

                                                                       String nama = etnama.getText().toString();
                                                                       hnama.setText("Nama : " + nama);
                                                                       String golrah = etgolrah.getText().toString();
                                                                       hgolrah.setText("Golongan Darah : " + golrah);
                                                                       int tahun = Integer.parseInt(ettl.getText().toString());
                                                                       htl.setText("Tahun Kelahiran : " + tahun);
                                                                       int no = Integer.parseInt(etno.getText().toString());
                                                                       hno.setText("No Telephone : " + no);
                                                                   }

                                                               }

                                                               private boolean isValid() {
                                                                   boolean valid = true;
                                                                   String hasil = null;
                                                                   if (menikah.isChecked()) {
                                                                       hasil = menikah.getText().toString();
                                                                       hstatus.setText("Status              : Menikah");
                                                                       valid = true;
                                                                   } else if (belum_menikah.isChecked()) {
                                                                       hasil = belum_menikah.getText().toString();
                                                                       hstatus.setText("Status              : Belum Menikah");
                                                                       valid = true;
                                                                   }


                                                                   String nama = etnama.getText().toString();
                                                                   String golrah = etgolrah.getText().toString();
                                                                   String tahun = ettl.getText().toString();
                                                                   String no = etno.getText().toString();
                                                                   String as = etalamat.getText().toString();


                                                                   if (nama.isEmpty()) {
                                                                       etnama.setError("Nama Belum diisi");
                                                                       valid = false;
                                                                   } else if (nama.length() < 3) {
                                                                       etnama.setError("Nama minimal 3 karakter");
                                                                       valid = false;
                                                                   } else {
                                                                       hnama.setText("Nama                   : " + nama);
                                                                   }

                                                                   if (golrah.isEmpty()) {
                                                                       etgolrah.setError("Golonga Darah Belum diisi");
                                                                       valid = false;
                                                                   } else {
                                                                       hgolrah.setText("Golonga Darah                : " + golrah);
                                                                   }
                                                                   if (tahun.isEmpty()) {
                                                                       ettl.setError("Tahun Kelahiran Belum diisi");
                                                                       valid = false;
                                                                   } else if (tahun.length() != 8) {
                                                                       ettl.setError("Format tahun ddmmyyyy");
                                                                       valid = false;
                                                                   } else {
                                                                       htl.setText("Tanggal Lahir     : " + tahun);
                                                                   }

                                                                   hkecamatan.setText("Asal                      : " + spkelurahan.getSelectedItem().toString()
                                                                           + " " + spkecamatan.getSelectedItem().toString());



                                                                   if (no.isEmpty()) {
                                                                       etno.setError("Nomor belum diisi");
                                                                       valid = false;
                                                                   } else if (no.length() < 6) {
                                                                       etno.setError("Nomor yang dimasukkan kurang");
                                                                       valid = false;
                                                                   } else if (no.length() > 12) {
                                                                       etno.setError("Nomor yang dimasukkan terlalu banyak");
                                                                       valid = false;
                                                                   } else {
                                                                       hno.setText("No Telepon         : " + no);
                                                                   }
                                                                   if (as.isEmpty()) {
                                                                       etalamat.setError("Alamat Belum diisi");
                                                                       valid = false;
                                                                   } else {
                                                                       halamat.setText("Alamat      : " + as);
                                                                   }

                                                                   String jk = null;
                                                                   if (laki.isChecked()) {
                                                                       jk = laki.getText().toString();
                                                                       hjk.setText("Jenis Kelamin    : Laki-laki");
                                                                       valid = true;
                                                                   } else if (perempuan.isChecked()) {
                                                                       jk = perempuan.getText().toString();
                                                                       hjk.setText("Jenis Kelamin    : Perempuan");
                                                                       valid = true;
                                                                   }

                                                                   String agama = "Agama yang dianut : ";
                                                                   int starteks = agama.length();
                                                                   if (islam.isChecked()) agama += islam.getText() + " ";
                                                                   if (kristen.isChecked()) agama += kristen.getText() + " ";
                                                                   if (konghuchu.isChecked()) agama += konghuchu.getText() + " ";
                                                                   if (katholik.isChecked()) agama += katholik.getText() + " ";
                                                                   if (budha.isChecked()) agama += budha.getText() + " ";


                                                                   if (agama.length() == starteks) agama += "Tidak ada";

                                                                   hagama.setText(agama);


                                                                   return false;
                                                               }
                                                           }

        );
    }
}
