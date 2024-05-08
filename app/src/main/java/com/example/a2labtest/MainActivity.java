package com.example.a2labtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

class Color{
    public String name;
    public Color(String name){
        this.name=name;
    }
    public String showColor(){
        return name;
    }
}
class Green extends Color{

    public Green() {
        super("Green");
    }
}
class Red extends Color{

    public Red() {
        super("Red");
    }
}
class Blue extends Color{

    public Blue() {
        super("Blue");
    }
}

class Vehicle{
    public String name;
    public int wheels;
    public float fuel=0;
    public float milage=0;

    public Vehicle(String name){
        this.name=name;
    }
    public String showVehicle(){
        return "the vehicle name is "+name;
    }

    public int getWheels(){
        return wheels;
    }
    public float getFuel(){
        return fuel;
    }
    public float getMilage(){
        return milage;
    }
    public void addPetrol(float petrol){
        fuel+=petrol;
    }
    public String drive(){

        return null;
    }

}

class Sedan extends Vehicle{
    public Sedan() {
        super("sedan");
        wheels=4;
    }

    public String drive(){
        if(fuel>=2){
            milage+=5;
            fuel-=2;
            return "ran 5 miles and burnt 2l fuel";
        }
        else{
            return "not enough fuel available";
        }
    }
}
class Motorcycle extends Vehicle{
    public Motorcycle() {
        super("motorcycle");
        wheels=2;
    }

    public String drive(){
        if(fuel>=0.5){
            milage+=1.5;
            fuel-=0.5;
            return "ran 1.5 miles and burnt 0.5l fuel";
        }
        else
            return "not enough fuel available";
    }
}
class SUV extends Vehicle{
    public SUV() {
        super("suv");
        wheels=6;
    }

    public String drive(){
        if(fuel>=2.5){
            milage+=4;
            fuel-=2.5;
            return "ran 4 miles and burnt 2.5l fuel";
        }
        else
            return "not enough fuel available";
    }
}
public class MainActivity extends AppCompatActivity {
    EditText vehicle,color,petrol;
    TextView t,p;
    Button addVehicle,AddPetrol,drive;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vehicle=findViewById(R.id.editTextsedan_moto_suv);
        color=findViewById(R.id.editTextRed_Green_Blue);
        petrol=findViewById(R.id.editTextAddPetrol);
        addVehicle=findViewById(R.id.buttonAddVehicle);
        AddPetrol=findViewById(R.id.buttonAddPetrol);
        drive=findViewById(R.id.buttonDrive);
        t=findViewById(R.id.textView3);
        p=findViewById(R.id.textView4);

        SUV suv=new SUV();
        Sedan sedan=new Sedan();
        Motorcycle motorcycle=new Motorcycle();


        addVehicle.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String color1=color.getText().toString();
                String vehicle1=vehicle.getText().toString();

                Vehicle vehicle=new Vehicle(vehicle1);
                Color color=new Color(color1);
                t.setText(color.showColor()+" and "+vehicle.showVehicle());


            }
        });
        AddPetrol.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String vehicle1=vehicle.getText().toString();
                float petrol1 = Float.parseFloat(petrol.getText().toString());
                if(vehicle1.matches("suv")){
                    suv.addPetrol(petrol1);
                    t.setText("petrol added "+petrol1+" liters");
                    p.setText("Fuel=>"+suv.getFuel());
                }

                else if (vehicle1.matches("motorcycle")) {
                    motorcycle.addPetrol(petrol1);
                    t.setText("petrol added "+petrol1+" liters");
                    p.setText("Fuel=>"+motorcycle.getFuel());

                } else if (vehicle1.matches("sedan")) {
                    sedan.addPetrol(petrol1);
                    t.setText("petrol added "+petrol1+" liters");
                    p.setText("Fuel=>"+sedan.getFuel());
                }
                else{
                    t.setText("appropriate vehicle not selected");
                }


            }
        });
        drive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String vehicle1=vehicle.getText().toString();
                if(vehicle1.matches("suv")) {
                    t.setText(suv.drive());
                    p.setText("Fuel=>"+suv.getFuel()+"Mileage=>"+suv.getMilage());
                }
                else if(vehicle1.matches("sedan")){
                    t.setText(sedan.drive());
                    p.setText("Fuel=>"+sedan.getFuel()+"Mileage=>"+sedan.getMilage());
                } else if (vehicle1.matches("motorcycle")) {
                    t.setText(motorcycle.drive());
                    p.setText("Fuel=>"+motorcycle.getFuel()+"Mileage=>"+motorcycle.getMilage());
                }
                else{
                    t.setText("appropriate vehicle not selected");
                    p.setText("");
                }
            }
        });
    }

}