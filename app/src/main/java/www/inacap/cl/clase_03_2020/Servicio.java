package www.inacap.cl.clase_03_2020;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class Servicio {

    private Conexion conex;
    public Servicio() {

    }
    public Servicio(Context context){
        conex=new Conexion(context);
    }
    public void insertar(Alumno p)
    {
        SQLiteDatabase db=conex.getWritableDatabase();
        try{
            ContentValues c=new ContentValues();
            c.put("id",p.getId());
            c.put("carrera",p.getCarrera());
            c.put("nombre",p.getNombre());
            db.insert("alumno",null,c);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally {
            db.close();
        }
    }

    public List<Alumno> getAlumno()
    {
        SQLiteDatabase db=conex.getReadableDatabase();
        List<Alumno> list=new ArrayList<>();
        try{
            Cursor cursor=db.rawQuery("select*from alumno",null);
            while(cursor.moveToNext())
            {
                Alumno p=new Alumno((cursor.getString(0) ),cursor.getString(1),
                        cursor.getString(2));
                list.add(p);

            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally {
            db.close();
        }
        return  list;
    }
}
