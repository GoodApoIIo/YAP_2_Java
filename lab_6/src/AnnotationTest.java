public class AnnotationTest {

    @MyAnnotations.Invoke
    public void myMethod() {
        System.out.println("Метод myMethod был вызван.");
    }

    @MyAnnotations.Default(value = String.class)
    class MyDefaultClass {
    }

    @MyAnnotations.ToString(value = MyAnnotations.ToString.ValueOption.NO)
    class MyToStringClass {
    }

    @MyAnnotations.Validate(value = {String.class, Integer.class})
    class MyValidateClass {
    }

    @MyAnnotations.Two(first = "Hello", second = 42)
    class MyTwoClass {
    }

    @MyAnnotations.Cache(value = {"item1", "item2"})
    class MyCacheClass {
    }

}