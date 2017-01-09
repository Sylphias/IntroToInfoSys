//package Extras;
//
//import android.os.Environment;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.EditText;
//import android.widget.TextView;
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import weka.core.Attribute;
//import weka.core.FastVector;
//import weka.core.Instance;
//import weka.core.Instances;
//import wlsvm.WLSVM;
//
//public class iotlab5 extends AppCompatActivity {
//    EditText sw;
//    EditText sl;
//    EditText pw;
//    EditText pl;
//    TextView display;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_iotlab5);
//        sw = (EditText) findViewById(R.id.sepal_width);
//        sl = (EditText) findViewById(R.id.sepal_length);
//        pw = (EditText) findViewById(R.id.petal_width);
//        pl = (EditText) findViewById(R.id.petal_length);
//        display = (TextView) findViewById(R.id.display);
//    }
//
//
//    protected BufferedReader readFile(File f) throws Exception{
//        BufferedReader reader = new BufferedReader(new FileReader(f));
//        return reader;
//    }
//
//    public void Classify(View v) {
//        Float pwValue = Float.parseFloat(pw.getText().toString());
//        Float plValue = Float.parseFloat(pl.getText().toString());
//        Float swValue = Float.parseFloat(sw.getText().toString());
//        Float slValue = Float.parseFloat(sl.getText().toString());
//        try{
//            WLSVM svmCls = new WLSVM();
//            svmCls = (WLSVM) weka.core.SerializationHelper.read("/sdcard/Download/m.model");
//
//// Declare four numeric attributes
//        Attribute Attribute1 = new Attribute("sepallength");
//        Attribute Attribute2 = new Attribute("sepalwidth");
//        Attribute Attribute3 = new Attribute("petallength");
//        Attribute Attribute4 = new Attribute("petalwidth");
//
//// Declare the class attribute along with its values (nominal)
//        FastVector fvClassVal = new FastVector(3);
//        fvClassVal.addElement("Iris-setosa");
//        fvClassVal.addElement("Iris-versicolor");
//        fvClassVal.addElement("Iris-virginica");
//        Attribute ClassAttribute = new Attribute("class", fvClassVal);
//
//// Declare the feature vector template
//        FastVector fvWekaAttributes = new FastVector(5);
//        fvWekaAttributes.addElement(Attribute1);
//        fvWekaAttributes.addElement(Attribute2);
//        fvWekaAttributes.addElement(Attribute3);
//        fvWekaAttributes.addElement(Attribute4);
//        fvWekaAttributes.addElement(ClassAttribute);
//
//// Creating testing instances object with name "TestingInstance"
//// using the feature vector template we declared above
//// and with initial capacity of 1
//
//        Instances testingSet = new Instances("TestingInstance", fvWekaAttributes, 1);
//
//// Setting the column containing class labels:
//        testingSet.setClassIndex(testingSet.numAttributes() - 1);
//
//// Create and fill an instance, and add it to the testingSet
//        Instance iExample = new Instance(testingSet.numAttributes());
//
//        iExample.setValue((Attribute)fvWekaAttributes.elementAt(0), slValue);
//        iExample.setValue((Attribute)fvWekaAttributes.elementAt(1), swValue);
//        iExample.setValue((Attribute)fvWekaAttributes.elementAt(2), plValue);
//        iExample.setValue((Attribute)fvWekaAttributes.elementAt(3), pwValue);
//        iExample.setValue((Attribute)fvWekaAttributes.elementAt(4),
//                "Iris-setosa"); // dummy
//        testingSet.add(iExample);
//            for(int i =0;i<testingSet.numInstances();i++){
//                double pred = svmCls.classifyInstance(testingSet.instance(i));
//                String prediction = testingSet.classAttribute().value((int) pred);
//                display.setText(prediction);
//    }
//}
//catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    public void Train(View v){
//        File root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
//        File f = new File(root, "iris_train.arff");
//        BufferedReader inputReader;
//        try {
//            inputReader = readFile(f);
//            Instances data = new Instances(inputReader);
//            data.setClassIndex(data.numAttributes() - 1);
//            WLSVM svmCls = new WLSVM();
//            svmCls.buildClassifier(data);
//            weka.core.SerializationHelper.write("/sdcard/Download/m.model", svmCls);
//
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
