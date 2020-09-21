package com.aust.healthmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class HealthCareActivity extends AppCompatActivity implements View.OnClickListener{
    TextView bp,diabetes,eyeDrop,gastricTrouble,heartDisease,kidneyDisease;
    TextView liverDisorder,muscleAndJointPain,skinProblem;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String foodText,lifeStyle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_care);
        this.setTitle("Health Care");
        bp = (TextView)findViewById(R.id.bpId);
        diabetes = (TextView)findViewById(R.id.diabetesId);
        eyeDrop = (TextView)findViewById(R.id.eyeDropId);
        gastricTrouble = (TextView)findViewById(R.id.gastricTroubleId);
        heartDisease = (TextView)findViewById(R.id.heartDiseaseId);
        kidneyDisease = (TextView)findViewById(R.id.kidneyDiseaseId);
        liverDisorder = (TextView)findViewById(R.id.liverDisorderId);
        muscleAndJointPain = (TextView)findViewById(R.id.muscleAndJointPainId);
        skinProblem = (TextView)findViewById(R.id.skinProblemId);
        bp.setOnClickListener(this);
        diabetes.setOnClickListener(this);
        eyeDrop.setOnClickListener(this);
        gastricTrouble.setOnClickListener(this);
        kidneyDisease.setOnClickListener(this);
        liverDisorder.setOnClickListener(this);
        muscleAndJointPain.setOnClickListener(this);
        heartDisease.setOnClickListener(this);
        skinProblem.setOnClickListener(this);
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
    }

    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.bpId) {
            Intent intent = new Intent(getApplicationContext(), diseaseDetailedActivity.class);
            intent.putExtra("name","Blood Pressure");
            foodText = "One or two cloves garlic everyday in the morning with water. Bananas contain plenty of potassium.potassium reduces the effects of sodium and alleviates tension in the walls of the blood vessels. One glass of coconut water should be taken. One cup celery juice with apple juice. two or three table spoons of apple cider vinegar for a month.";
            lifeStyle = "Lose extra pounds and watch your waistline. Exercise regularly. Eat a healthy diet. Reduce sodium in your diet.Limit the amount of alcohol you drink. Quit smoking. Cut back on caffeine. Reduce your stress.";
            DocumentReference documentReference = fStore.collection("healthCareInformation").document("bloodPressure");
            Map<String,Object> bp = new HashMap<>();
            bp.put("food",foodText);
            bp.put("lifeStyle",lifeStyle);
            intent.putExtra("disease","bloodPressure");
            documentReference.set(bp).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(getApplicationContext(),"Blood Pressure Details",Toast.LENGTH_SHORT).show();
                }
            });

            startActivity(intent);
        }

        if(v.getId()==R.id.diabetesId)
        {
            Intent intent = new Intent(getApplicationContext(), diseaseDetailedActivity.class);
            intent.putExtra("name","Diabetes");
            foodText = "Instead, eat carbohydrates from fruit, vegetables, whole grains, beans, and low-fat or nonfat milk. Choose healthy carbohydrates, such as fruit, vegetables, whole grains, beans, and low-fat milk, as part of your diabetes meal plan.";
            lifeStyle = "The recommended lifestyle interventions include: Taking two and a half hours each week of moderate intensity physical activity or one hour and 15 minutes of high intensity exercise.";
            DocumentReference documentReference = fStore.collection("healthCareInformation").document("diabetes");
            Map <String,Object> bp = new HashMap<>();
            bp.put("food",foodText);
            bp.put("lifeStyle",lifeStyle);
            intent.putExtra("disease","diabetes");
            documentReference.set(bp).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(getApplicationContext(),"Diabetes Details",Toast.LENGTH_SHORT).show();
                }
            });
            startActivity(intent);
        }

        if(v.getId()==R.id.eyeDropId)
        {
            Intent intent = new Intent(getApplicationContext(),diseaseDetailedActivity.class);
            intent.putExtra("name","Eye Drop");
            foodText = "Green leafy vegetables like spinach, kale, and collards. Salmon, tuna, and other oily fish. Eggs, nuts, beans, and other nonmeat protein sources. Oranges and other citrus fruits or juices. Oysters and pork.Fish,Nuts and legumes.Nuts are also rich in omega-3 fatty acids,Seeds,Citrus fruits,Leafy green vegetables,Carrots,Sweet potatoes,Beef.";
            lifeStyle = "Lifelong good nutrition may lower your risk of some eye diseases. By eating a healthy, balanced diet, you will have a better chance of staying healthy and keeping your eyes healthy. A lifetime diet rich in certain dark green vegetables, such as spinach and kale, may reduce your risk of getting AMD.";
            DocumentReference documentReference = fStore.collection("healthCareInformation").document("EyeDrop");
            Map <String,Object> bp = new HashMap<>();
            bp.put("food",foodText);
            bp.put("lifeStyle",lifeStyle);
            intent.putExtra("disease","EyeDrop");
            documentReference.set(bp).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(getApplicationContext(),"Eye Drop Details",Toast.LENGTH_SHORT).show();
                }
            });
            startActivity(intent);
        }
        if(v.getId()==R.id.gastricTroubleId)
        {
            Intent intent = new Intent(getApplicationContext(),diseaseDetailedActivity.class);
            intent.putExtra("name","Gastric Trouble");
            foodText = "Vegetables such as lettuce, tomatoes, zucchini, okra, Fruits such as cantaloupe, grapes, berries, cherries, avocado, olives. Carbohydrates such as gluten-free bread, rice bread, rice.";
            lifeStyle = "Fiber-rich foods add bulk to your stools, which helps regulate your digestion. Increase your fiber intake gradually to prevent bloating, gas, and diarrhea. Eat several small meals throughout the day to prevent the sudden bowel contractions that large meals can cause.";
            DocumentReference documentReference = fStore.collection("healthCareInformation").document("gastricTrouble");
            Map <String,Object> bp = new HashMap<>();
            bp.put("food",foodText);
            bp.put("lifeStyle",lifeStyle);
            intent.putExtra("disease","gastricTrouble");
            documentReference.set(bp).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(getApplicationContext(),"Gastric Troubled Details",Toast.LENGTH_SHORT).show();
                }
            });
            startActivity(intent);
        }
        if(v.getId()==R.id.heartDiseaseId)
        {
            Intent intent = new Intent(getApplicationContext(),diseaseDetailedActivity.class);
            intent.putExtra("name","Heart Disease");
            foodText = "Eat protein–rich foods, including fish, lean meats, skinless poultry, eggs, nuts and seeds, and beans. Try a diet. The DASH eating plan is a heart-healthy approach that lowers blood pressure and bad cholesterol in your blood";
            lifeStyle = "These include eating a low-fat and low-sodium diet, getting at least 30 minutes of moderate exercise on most days of the week, quitting smoking, and limiting alcohol intake.";
            DocumentReference documentReference = fStore.collection("healthCareInformation").document("heartDisease");
            Map <String,Object> bp = new HashMap<>();
            bp.put("food",foodText);
            bp.put("lifeStyle",lifeStyle);
            intent.putExtra("disease","heartDisease");
            documentReference.set(bp).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(getApplicationContext(),"Heart Disease Details",Toast.LENGTH_SHORT).show();
                }
            });
            startActivity(intent);
        }
        if(v.getId()==R.id.kidneyDiseaseId)
        {
            Intent intent = new Intent(getApplicationContext(), diseaseDetailedActivity.class);
            intent.putExtra("name","Kidney Disease");
            foodText = "The DASH Diet is rich in fruits, vegetables, low-fat dairy products, whole grains, fish, poultry, beans, seeds, and nuts. It is low in salt and sodium, added sugars and sweets, fat and red meats. The DASH diet is a recognized treatment for hypertension, heart disease, and kidney disease.";
            lifeStyle = "Maintain Normal Blood Pressure. High blood pressure is a common cause of CKD. Lose Excess Weight. Excess weight or obesity can lead to high blood pressure and diabetes.Control Blood Glucose Levels. High blood glucose levels make CKD worse.Stop Smoking. Smoking makes CKD worse.Change Your Diet.Regular Exercise.References.";
            DocumentReference documentReference = fStore.collection("healthCareInformation").document("kidneyDisease");
            Map <String,Object> bp = new HashMap<>();
            bp.put("food",foodText);
            bp.put("lifeStyle",lifeStyle);
            intent.putExtra("disease","kidneyDisease");
            documentReference.set(bp).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(getApplicationContext(),"Kidney Disease Details",Toast.LENGTH_SHORT).show();
                }
            });
            startActivity(intent);
        }


        if(v.getId()==R.id.liverDisorderId)
        {
            Intent intent = new Intent(getApplicationContext(), diseaseDetailedActivity.class);
            intent.putExtra("name","Liver Disorder");
            foodText = "Grains, fruits, vegetables, meat and beans, milk, and oil. Eat food with fiber: Fiber helps your liver work at an optimal level. Fruits, vegetables, whole grain breads, rice and cereals can take care of your body's fiber needs.";
            lifeStyle = "Lifestyle changes cannot cure cirrhosis, but they can help to delay or stop progression of the disease, reduce the severity of symptoms, and help prevent complications. Avoid drinking alcohol. Eat a balanced diet. Avoid raw seafood, raw fish, and shellfish.";
            DocumentReference documentReference = fStore.collection("healthCareInformation").document("liverDisorder");
            Map <String,Object> bp = new HashMap<>();
            bp.put("food",foodText);
            bp.put("lifeStyle",lifeStyle);
            intent.putExtra("disease","liverDisorder");
            documentReference.set(bp).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(getApplicationContext(),"Liver Disorder Details",Toast.LENGTH_SHORT).show();
                }
            });
            startActivity(intent);
        }
        if(v.getId()==R.id.muscleAndJointPainId)
        {
            Intent intent = new Intent(getApplicationContext(),diseaseDetailedActivity.class);
            intent.putExtra("name","Muscle and Joint Pain");
            foodText = "Olive oil and coconut oil and other healthy fats. Whole grains. Salmon, sardines, herring, mackerel, anchovies and other fatty fish. Almonds and other nuts.";
            lifeStyle = "Keeping your weight within a healthy range is the best thing you can do for your joints.Exercise can help you lose extra pounds and maintain a healthy weight. Take frequent breaks at work, and stretch or go for a short walk. If you can't leave the office, try taking phone calls while standing.";
            DocumentReference documentReference = fStore.collection("healthCareInformation").document("muscleAndJointPain");
            Map <String,Object> bp = new HashMap<>();
            bp.put("food",foodText);
            bp.put("lifeStyle",lifeStyle);
            intent.putExtra("disease","muscleAndJointPain");
            documentReference.set(bp).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(getApplicationContext(),"Muscle And Joint Pain Details",Toast.LENGTH_SHORT).show();
                }
            });
            startActivity(intent);
        }

        if(v.getId()== R.id.skinProblemId)
        {
            Intent intent = new Intent(getApplicationContext(), diseaseDetailedActivity.class);
            intent.putExtra("name","Skin Problem");
            foodText = "Avocado-A good source of Biotin.Green tea. A good source of Anti-oxidant called Polyphenols.Tomatoes- A good source of Anti-oxidant called Lycopene. Salmon.Eggs.Pomegranate.Walnuts.Beans.";
            lifeStyle = "Protect Your Skin from the Sun.Avoid Stress and Get Exercise.Eat Healthy.Limit Alcohol and Avoid SmokingDrinking alcohol in large amounts can cause a flare of a number skin conditions, such as psoriasis, acne, and rosacea.Get Plenty of Sleep.Take Time to Rejuvenate Your Skin.";
            DocumentReference documentReference = fStore.collection("healthCareInformation").document("skinProblem");
            Map <String,Object> bp = new HashMap<>();
            bp.put("food",foodText);
            bp.put("lifeStyle",lifeStyle);
            intent.putExtra("disease","skinProblem");
            documentReference.set(bp).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(getApplicationContext(),"Skin Problem Details",Toast.LENGTH_SHORT).show();
                }
            });
            startActivity(intent);
        }


    }
}