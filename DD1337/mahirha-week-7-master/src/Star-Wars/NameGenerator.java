import java.lang.StringBuilder;
/**
    Your Star Wars first name:
    1 Take the first three letters of your last name.
    2 Add to that the first two letters of your first name.

    Your Star Wars last name:
    1 Take the first two letters of your mother’s maiden name.
    2 Add to this the first three letters of the name of the town or city where you were born.

    Uses StringBuilder
 */


public class NameGenerator{

    private StringBuilder starWarsName;

    public static void main(String[] args) {
        if(args.length < 4) {
            System.out.println("Use: NameGenerator Firstname Lastname MothersMaidenName PlaceOfBirth");
            return;
        }
        NameGenerator name = new NameGenerator();
        System.out.println(name.generateName(args[0], args[1], args[2], args[3]));
        
    }

    // Construct
    public NameGenerator(){
        starWarsName = new StringBuilder();
    }

    // Generator
    public String generateName(String f, String s, String maiden, String birth){
        
        // Capital first letter
        starWarsName.append(s.substring(0, 1).toUpperCase());
        starWarsName.append(s.substring(1, 3).toLowerCase());
        starWarsName.append(f.substring(0, 2).toLowerCase());

        starWarsName.append(" ");

        // Capital first letter
        starWarsName.append(maiden.substring(0,1).toUpperCase());
        starWarsName.append(maiden.substring(1,2).toLowerCase());
        starWarsName.append(birth.substring(0,3).toLowerCase());

        return starWarsName.toString();
    }
}
