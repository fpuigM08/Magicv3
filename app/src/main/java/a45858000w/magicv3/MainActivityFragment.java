package a45858000w.magicv3;



import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import static android.R.attr.button;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    //Jugador 1
    Button btmasVeneno1;
    Button btmasVida1;
    Button btmenosVida1;
    Button btmenosVeneno1;
    Button btquitarVida1;
    int Vida1=20;
    int Veneno1=0;

    //Jugador 2
    Button btmasVida2;
    Button btmasVeneno2;
    Button btmenosVida2;
    Button btmenosVeneno2;
    Button btquitarVida2;
    int Vida2=20;
    int Veneno2=0;
    TextView txtDatos1;
    TextView txtDatos2;
    View view;


    public MainActivityFragment() {

    }
    //Crear el menu opciones
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu,inflater);
        inflater.inflate(R.menu.menu_main, menu);

    }

    //crear el boton en el menu opciones
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.reset)
        {
            Reset();
            return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }

    //resetear variables
    private void Reset() {
        //mensaje flotante
        Snackbar.make(getView(), "Resetear ?", Snackbar.LENGTH_LONG)
                .setAction("Aceptar", null)
                .setActionTextColor(Color.RED)
                .show();

        Vida1=20;
        Vida2=20;
        Veneno1=0;
        Veneno2=0;
        txtDatos2.setText(String.format("%1$d / %2$d",Vida2,Veneno2));
        txtDatos2.setText(String.format("%1$d / %2$d",Vida2,Veneno2));
    }

    //al crear el layout que contenga el menu opciones
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    //al crear la vista del layout
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_main, container, false);



        txtDatos1 = (TextView) view.findViewById( R.id.txtDatos1 );
        txtDatos2 = (TextView) view.findViewById( R.id.txtDatos2 );

        //recuperar datos al haber girado la pantalla
        if (savedInstanceState != null) {
            Vida1 = savedInstanceState.getInt("vida1");
            Vida2 = savedInstanceState.getInt("vida2");
            Veneno1 = savedInstanceState.getInt("veneno2");
            Veneno2 = savedInstanceState.getInt("veneno2");
            txtDatos1.setText(String.format("%1$d / %2$d",Vida1,Veneno1));
            txtDatos2.setText(String.format("%1$d / %2$d",Vida2,Veneno2));

        }
        /* boton mas vida (hp, health points) Player One*/
        btmasVida1 = (Button) view.findViewById( R.id.btmasVida1);
        btmasVida1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Vida1++;
                txtDatos1.setText(String.format("%1$d / %2$d",Vida1,Veneno1));
            }
        });

        /* boton menos vida (hp, health points) Player One*/
        btmenosVida1 = (Button) view.findViewById( R.id.btmenosVida1 );
        btmenosVida1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v){
                Vida1--;
                txtDatos1.setText(String.format("%1$d / %2$d",Vida1,Veneno1));

            }
        });

        /* boton mas veneno Player One */
        btmasVeneno1 = (Button) view.findViewById( R.id.btmasVeneno1 );
        btmasVeneno1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ){
                Veneno1++;
                txtDatos1.setText( String.format("%1$d / %2$d",Vida1,Veneno1) );
            }

        });

        /* boton menos veneno Player One */
        btmenosVeneno1 = (Button) view.findViewById( R.id.btmenosVeneno1 );
        btmenosVeneno1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ){
                Veneno1--;
                if (Veneno1<0)
                    Veneno1=0;
                txtDatos1.setText( String.format("%1$d / %2$d",Vida1,Veneno1));
            }

        });



        /* boton quitar Vida de P1 a P2 */
        btquitarVida1 = (Button) view.findViewById( R.id.btquitarVida1 );
        btquitarVida1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ){
                Vida1--;
                txtDatos1.setText( String.format("%1$d / %2$d",Vida1,Veneno1));
                Vida2++;
                txtDatos2.setText(String.format("%1$d / %2$d",Vida2,Veneno2));
            }

        });



        /* boton mas vida Player Two */
        btmasVida2 = (Button) view.findViewById( R.id.btmasVida2 );
        btmasVida2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v){
                Vida2++;
                txtDatos2.setText(String.format("%1$d / %2$d",Vida2,Veneno2));
            }
        });

        /* boton menos vida Player Two */
        btmenosVida2 = (Button) view.findViewById( R.id.btmenosVida2);
        btmenosVida2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v){
                Vida2--;
                txtDatos2.setText( String.format("%1$d / %2$d",Vida2,Veneno2));
            }
        });

        /* boton mas veneno Player Two */
        btmasVeneno2 = (Button) view.findViewById( R.id.btmasVeneno2 );
        btmasVeneno2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v){
                Veneno2++;
                txtDatos2.setText( String.format("%1$d / %2$d",Vida2,Veneno2) );
            }
        });

        /* boton menos veneno Player Two */
        btmenosVeneno2 = (Button) view.findViewById( R.id.btmenosVeneno2 );
        btmenosVeneno2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v){
                Veneno2--;
                if (Veneno2<0)
                    Veneno2=0;
                txtDatos2.setText( String.format("%1$d / %2$d",Vida2,Veneno2) );
            }
        });


        /* boton quitar Vida de P2 a P1 */
        btquitarVida2 = (Button) view.findViewById( R.id.btquitarVida2 );
        btquitarVida2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ){
                Vida2--;
                txtDatos2.setText( String.format("%1$d / %2$d",Vida2,Veneno2));
                Vida1++;
                txtDatos1.setText(String.format("%1$d / %2$d",Vida1,Veneno1));
            }

        });


        return view;
    }

    //guardar datos al girar pantalla
    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("vida1",Vida1);
        outState.putInt("vida2",Vida2);
        outState.putInt("veneno1",Veneno1);
        outState.putInt("veneno2",Veneno2);

        super.onSaveInstanceState(outState);
    }
}
