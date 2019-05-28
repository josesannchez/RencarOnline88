package sanchezartega.facci.rencaronline.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

import sanchezartega.facci.rencaronline.MainActivity;
import sanchezartega.facci.rencaronline.R;
import sanchezartega.facci.rencaronline.adapters.PersonajesAdapter;
import sanchezartega.facci.rencaronline.clases.PersonajeVo;




public class ListaPersonajesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    RecyclerView recyclerPersonajes;
    ArrayList<PersonajeVo> listaPersonaje;

    public ListaPersonajesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListaPersonajesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListaPersonajesFragment newInstance(String param1, String param2) {
        ListaPersonajesFragment fragment = new ListaPersonajesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista=inflater.inflate(R.layout.fragment_lista_personajes, container, false);

        listaPersonaje=new ArrayList<>();
        recyclerPersonajes= (RecyclerView) vista.findViewById(R.id.recyclerId);
        recyclerPersonajes.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarLista();

        PersonajesAdapter adapter=new PersonajesAdapter(listaPersonaje);
        recyclerPersonajes.setAdapter(adapter);

        return vista;
    }


            private void llenarLista() {
                listaPersonaje.add(new PersonajeVo("Kia", "Kia Motors es un fabricante surcoreano de automóviles. Su sede central está ubicada en Yangjae-dong, Seocho-gu, Seúl, Corea del Sur.", R.drawable.ki));
                listaPersonaje.add(new PersonajeVo("Chevrolet", "Chevrolet es una marca de automóviles y camiones con sede en Estados Unidos perteneciente al grupo General Motors. Nació de la alianza de Louis Chevrolet y William Crapo Durant el 3 de noviembre de 1911, \u200B en los Estados Unidos, fabricando automóviles robustos. .", R.drawable.chebrole));
                listaPersonaje.add(new PersonajeVo("Renault Mégane:", "siempre ha sido uno de los preferidos de los españoles. Hay un montón de motores donde elegir, tantos como seis: tres de gasolina y otros tres diésel.", R.drawable.gol));
                listaPersonaje.add(new PersonajeVo("Volkswagen Golf:", "La séptima generación del VW Golf está disponible también con una amplia gama de motores, tipos de tracción y cajas de cambios..", R.drawable.mw));
                listaPersonaje.add(new PersonajeVo(" Tesla Roadster", "El Tesla Roadster es un automóvil deportivo totalmente eléctrico, el primer modelo producido", R.drawable.ki));

            }


            // TODO: Rename method, update argument and hook method into UI event
            public void onButtonPressed(Uri uri) {
                if (mListener != null) {
                    mListener.onFragmentInteraction(uri);
                }
            }

            @Override
            public void onAttach(Context context) {
                super.onAttach(context);
                if (context instanceof OnFragmentInteractionListener) {
                    mListener = (OnFragmentInteractionListener) context;
                } else {
                    throw new RuntimeException(context.toString()
                            + " must implement OnFragmentInteractionListener");
                }
            }

            @Override
            public void onDetach() {
                super.onDetach();
                mListener = null;
            }

            /**
             * This interface must be implemented by activities that contain this
             * fragment to allow an interaction in this fragment to be communicated
             * to the activity and potentially other fragments contained in that
             * activity.
             * <p>
             * See the Android Training lesson <a href=
             * "http://developer.android.com/training/basics/fragments/communicating.html"
             * >Communicating with Other Fragments</a> for more information.
             */
            public interface OnFragmentInteractionListener {
                // TODO: Update argument type and name
                void onFragmentInteraction(Uri uri);
            }
        }
