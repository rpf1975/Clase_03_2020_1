package www.inacap.cl.clase_03_2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private EditText id;
    private EditText nombre;
    private EditText carrera;
    private Servicio servicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        servicio=new Servicio(getBaseContext());
        listView=(ListView) findViewById(R.id.listAlumnos );
        id=(EditText) findViewById(R.id.idAlumno);
        nombre=(EditText) findViewById(R.id.nombreAlumno );
        carrera=(EditText) findViewById(R.id.carreraAlumno );
    }
    public void agregarAlumno(View view)
    {
        String ide=id.getText().toString();
        String nom=nombre.getText().toString();
        String carr=carrera.getText().toString();
        Alumno al=new Alumno();
        al.setNombre(nom);
        al.setId(ide);
        al.setCarrera(carr);
        servicio.insertar(al);
        cargarlista();
        Toast t= Toast.makeText(this,"Agregado",Toast.LENGTH_SHORT);
        t.show();

    }
    private void cargarlista()
    {

        ArrayAdapter<Alumno> adapter=new ArrayAdapter<Alumno>(this,android.R.layout.simple_list_item_1,servicio.getAlumno());
        Toast t= Toast.makeText(this,"Lista",Toast.LENGTH_SHORT);
        t.show();
        listView.setAdapter(adapter);
    }
}