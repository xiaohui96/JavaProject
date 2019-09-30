//定义接口
interface drawTest{
    //定义方法
    public void draw();
}
//定义四边形类
public class QuadrangleUseInterface {
    void doAnything(){
        //SomeSentence
    }
}
//定义平行四边形类，该类继承四边形类，并实现了drawTest接口
class ParallelogramgleUseInterface extends QuadrangleUseInterface implements
        drawTest{
    //由于该类实现了接口，所以需要覆盖draw()方法
    public void draw(){
        System.out.println("平行四边形.draw()");
    }
    //覆盖父类方法
    void doAnything(){
        //SomeSentence
    }
    }
class SequareUseInterface extends QuadrangleUseInterface implements
        drawTest{
    @Override
    public void draw() {
        System.out.println("正方形.draw()");
    }

    @Override
    void doAnything() {
        super.doAnything();
    }
}
class AnyThingUseInterface extends QuadrangleUseInterface{
    @Override
    void doAnything() {
        super.doAnything();
    }
    public static void main(String[] args){
        
    }
}
