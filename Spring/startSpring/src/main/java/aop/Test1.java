package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        UniLibrary UniLibrary =  context.getBean("uniLibrary", UniLibrary.class);
        Book book = context.getBean("book", Book.class);

        UniLibrary.getBook();
        UniLibrary.addBook("Vasyl", book);
        UniLibrary.addMagazine();

//        UniLibrary.returnMagazine();
//        UniLibrary.addBook();

//        UniLibrary.returnBook();
//        UniLibrary.getMagazine();

//        SchoolLibrary SchoolLibrary =  context.getBean("schoolLibrary", aop.SchoolLibrary.class);
//        SchoolLibrary.getBook();

        context.close();
    }
}
