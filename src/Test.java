
public class Test {

    /**
     * 类的静态加载
     * 在代码运行之前就会将所有类全部加载到内存
     *      类加载：将class文件读取到内存，抽象成一个class对象  Class类的对象  （类对象）
     *
     * @param args
     */
    public static void main(String[] args) throws ClassNotFoundException {
        if ("Student".equals(args[0])){
            Student student = new Student();
        }else if("persion".equals(args[0])){
            Persion persion = new Persion();
        }

        /**
         * 类的动态加载
         *当代码运行到这一行的时候才会加载这个类
         *
         *
         * dog ：代表Dog.class文件在java内存里面的一个抽象，类对象
         */
        Class dog = Class.forName(args[0]);
        System.out.println(dog);


        //获取类对象的三种方式
        /**
         * 同一个类的类对象不管用什么方式获取都是同一个对象
         *
         */
        Class c =  Class.forName("Student");

        /**
         *  new Student();   创建一个类的对象
         *  Student.class;   获取类的类对象
         *
         */

        Class studentClass = Student.class;

        Student student = new Student();

        Class aClass = student.getClass();

        //==   比较内存地址
        System.out.println(c == studentClass);

        System.out.println(studentClass == aClass);


    }
}
