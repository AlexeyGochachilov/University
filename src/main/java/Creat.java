public class Creat {

    public static void main(String[] args) {

//        University mgu = new University("01", "Московский государственный университет",
//                "МГУ", 1755, StudyProfile.ECONOMICS);
//
//        Student ivanov = new Student(
//                4.5f, 3, "01", "Иванов Иван Иванович");
//
//        System.out.println(mgu);
//        System.out.println(ivanov);
        System.out.println(ReadFromExcel.read("universityInfo.xlsx"));
    }
}
