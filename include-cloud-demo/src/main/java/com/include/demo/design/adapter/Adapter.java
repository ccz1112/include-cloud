package com.include.demo.design.adapter;

/**
 * @author: chenshuo
 * @Date: 2023-05-16
 * @Time: 16:08
 * @version： 1.0
 * @Description:适配器模式demo
 **/
public class Adapter {

    /**
     *
     * ***/
    public static void main(String[] args) {
        TypeCAdapter typeCAdapter = new TypeCAdapter();
        Mac mac = new Mac();
        typeCAdapter.setSd(new SD());
        mac.printData(typeCAdapter);
    }
}

interface TypeC{
    String readData();
}

class TypeCUsb implements TypeC{

    @Override
    public String readData() {
        return "通过TypeC接口读取数据";
    }
}

class SD{
    public String inputData(){
        return "SD卡读取数据";
    }
}

class TF{
    public String flashData(){
        return "TF卡刷新数据";
    }
}

class TypeCAdapter implements TypeC{

    private SD sd;
    private TF tf;



    @Override
    public String readData() {
        if(sd!=null){
            return sd.inputData();
        }
        if(tf!=null){
            return tf.flashData();
        }
        return "123456";
    }

    public void setSd(SD sd) {
        this.sd = sd;
    }
    public void setTf(TF tf) {
        this.tf = tf;
    }
}

class Mac{
    public void printData(TypeC typeC){
        System.out.println(typeC.readData());
    }
}

