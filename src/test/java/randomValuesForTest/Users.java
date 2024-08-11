package randomValuesForTest;

import com.github.javafaker.Faker;

public class Users {
    Faker faker = new Faker();

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String email = faker.internet().emailAddress();
    public String gender = faker.options().option("Male", "Female", "Other");
    public String userNumber = faker.number().digits(10);
    public String wrongUserNumber = faker.number().digits(9);
    public String year = Integer.toString(faker.number().numberBetween(1900, 2100));
    public String month = faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    public String day = Integer.toString(getRandomDay());
    public String randomSubject = faker.options().option("Maths", "Accounting", "Arts",
            "Social Studies", "Biology", "Physics", "Chemistry",
            "Computer Science", "Commerce",
            "Economics", "Civics", "Hindi",
            "English", "History");
    public String hobby = faker.options().option("Reading", "Sports", "Music");
    public String pictureStatic = "mushroom.jpg";
    public String userAddress = faker.address().streetAddress();
    public String randomState = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public String randomCity = getRandomCity();

    public int getRandomDay() {
        int yearForRandomMonth = faker.number().numberBetween(1900, 2100);
        if (month.equals("February")) {
            if ((yearForRandomMonth % 4 == 0 && yearForRandomMonth % 100 != 0) || (yearForRandomMonth % 400 == 0)) {
                return faker.number().numberBetween(1, 29);
            } else {
                return faker.number().numberBetween(1, 28); // Невисокосный год
            }
        } else if (month.equals("April") || month.equals("June") ||
                month.equals("September") || month.equals("November")) {
            return faker.number().numberBetween(1, 30);
        } else {
            return faker.number().numberBetween(1, 31);
        }
    }

    public String getRandomCity() {
        if (randomState.equals("NCR")) {
            return faker.options().option("Delhi", "Gurgaon", "Noida");
        } else if (randomState.equals("Uttar Pradesh")) {
            return faker.options().option("Agra", "Lucknow", "Merrut");
        }
        else if (randomState.equals("Haryana")) {
            return faker.options().option("Karnal", "Panipat");
    } else {
            return faker.options().option("Jaipur", "Jaiselmer");
        }
}}
