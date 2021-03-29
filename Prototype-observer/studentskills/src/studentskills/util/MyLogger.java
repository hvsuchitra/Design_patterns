package studentskills.util;


public class MyLogger{
public static enum DebugLevel
{
        CONSTRUCTOR,
        FILE_PROCESSOR,
        INSERT_NODE,
        MODIFY_NODE,
        NONE;
};

private static DebugLevel debugLevel;


// FIXME: Add switch cases for all the levels
public static void setDebugValue (int levelIn) {
        switch (levelIn) {
                case 4:
                        debugLevel = DebugLevel.MODIFY_NODE;
                        break;
                case 3:
                        debugLevel = DebugLevel.INSERT_NODE;
                        break;

                case 2:
                        debugLevel = DebugLevel.CONSTRUCTOR;
                        break;
                case 1:
                        debugLevel = DebugLevel.FILE_PROCESSOR;
                        break;
                default:
                        debugLevel = DebugLevel.NONE;
                        break;
        }
}

public static void setDebugValue (DebugLevel levelIn) {
        debugLevel = levelIn;
        }

public static void writeMessage (String     message  ,
        DebugLevel levelIn ) {
        if (levelIn == debugLevel){

                System.out.println(message);
        }

        }

public String toString()
        {
        return "The debug level has been set to the following " + debugLevel;
        }
}