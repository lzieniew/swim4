package lukzieniewicz.gmail.com.swim4;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment implements RadioGroup.OnCheckedChangeListener {

    AppCompatActivity A1;
    OnWyborOpcjiListener sluchaczF1;

    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment1, container, false);
    }

    @Override
    public void onAttach(Context c){
        super.onAttach(c);
        try{
            A1 = (AppCompatActivity) c;
            sluchaczF1 = (OnWyborOpcjiListener) c;
        }
        catch (Exception e){
            throw new ClassCastException(A1.toString());
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId){
            case R.id.radio1: sluchaczF1.onWyborOpcji(0);
                break;
            case R.id.radio2: sluchaczF1.onWyborOpcji(1);
                break;
            case R.id.radio3: sluchaczF1.onWyborOpcji(2);
                break;
        }
    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        ((RadioGroup) getActivity().findViewById(R.id.radio_group)).setOnCheckedChangeListener(this);
    }

    public interface OnWyborOpcjiListener{
        public void onWyborOpcji(int opcja);
    }

}
