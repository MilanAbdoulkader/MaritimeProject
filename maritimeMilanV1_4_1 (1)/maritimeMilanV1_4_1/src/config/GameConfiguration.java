package config;

public class GameConfiguration{
    public static final int WINDOW_WIDTH = 1600;
    public static final int WINDOW_HEIGHT = 864;

    public static final int BLOCK_SIZE = 8;

    public static final int ROW_COUNT= WINDOW_HEIGHT/BLOCK_SIZE;
    public static final int COLUMN_COUNT = WINDOW_WIDTH/BLOCK_SIZE;

    public static final int BEGIN_FlEET_ROW = 15;
    public static final int BEGIN_FLEET_COLUMN = 10;

    public static final int GAME_SPEED = 1;

    //ALLIGNEMENT FLOTTE et PORT ////////////////// NOUVEAU
    public static boolean ALLY = true;


    // Transport boolean

    public static boolean wayForward = true;
    public static boolean wayBack = true;

    // Color Change
    public static boolean STATE = true;

    public static final int HARBOR_COUNT = 8;
    

    //Pirate ship and fleets Configuration

    public static final String[] PIRATE_NAMES = {"José","Dark_Predator","Terreur des Tenebres","Golum","Musculator","La rose des vents"};
    public static final int PIRATE_FLEET_COUNT = 5;
    

    //LAND 1
    public static final int LAND1_ROW[] = {10,11,12,13,14,15,16,17,18,19,20};
    public static final int LAND1_COLUMN[]= {2,3,4,5,6,7,8};


    // HARBOR 1 (en haut a gauche)

    public static final String STARTING_HARBOR = "STARTING_HARBOR";
    
    public static final int HARBOR1_STARTING_ROW = 14;
    public static final int HARBOR1_STARTING_COLUMN = 7;

    public static final int HARBOR1_FINISHING_ROW = 17;
    public static final int HARBOR1_FINISHING_COLUMN = 9;

    //ISLAND 1 REFINING

    public static final int LAND1Point1_ROW[] = {10,20};
    public static final int LAND1Point1_COLUMN[]= {9,10,11,12,13};

    public static final int LAND1Point2_ROW[] = {11,19};
    public static final int LAND1Point2_COLUMN[]= {9,10,11,12};


    public static final int LAND1Point3_ROW[] = {12,18};
    public static final int LAND1Point3_COLUMN[]= {9,10,11};


    public static final int LAND1Point4_ROW[] = {13,17};
    public static final int LAND1Point4_COLUMN[]= {9,10};

    public static final int LAND1Point5_ROW[] = {14,16};
    public static final int LAND1Point5_COLUMN[]= {9};


    // ISLAND 2 (continent en bas a gauche)

    public static final int ISLAND2_STARTING_ROW = 107;
    public static final int ISLAND2_STARTING_COLUMN = 19;

    public static final int ISLAND2_FINISHING_ROW = 75;
    public static final int ISLAND2_FINISHING_COLUMN = 0;


    //HARBOR 2
    
    public static final String CONTINENT = "CONTINENT";

    public static final int HARBOR2_STARTING_ROW = 95;
    public static final int HARBOR2_STARTING_COLUMN = 7;

    public static final int HARBOR2_FINISHING_ROW = 97;
    public static final int HARBOR2_FINISHING_COLUMN = 9;


    // ISLAND 3 (le marteau)
    

    public static final int ISLAND3_STARTING_ROW = 56;
    public static final int ISLAND3_STARTING_COLUMN = 50;

    public static final int ISLAND3_FINISHING_ROW = 53;
    public static final int ISLAND3_FINISHING_COLUMN = 44;
    
    
    
    public static final int ISLAND3Point1_ROW[] = {57,58,59,60,61,62,63};
    public static final int ISLAND3Point1_COLUMN[]= {47,48};
    
    
    

    // HARBOR 3
    
    public static final String HAMMER = "HAMMER";

    public static final int HARBOR3_STARTING_ROW = 55;
    public static final int HARBOR3_STARTING_COLUMN = 44;

    public static final int HARBOR3_FINISHING_ROW = 57;
    public static final int HARBOR3_FINISHING_COLUMN = 45;
    
    

    // ISLAND 4 tt a droite 
    
   

    public static final int ISLAND4_STARTING_ROW = 35;
    public static final int ISLAND4_STARTING_COLUMN = 175;
    
    public static final int ISLAND4_FINISHING_ROW = 15;
    public static final int ISLAND4_FINISHING_COLUMN = 185;

    // HARBOR 4
    
    public static final String TRIANGLE = "TRIANGLE";

    public static final int HARBOR4_STARTING_ROW = 32;
    public static final int HARBOR4_STARTING_COLUMN = 184;

    public static final int HARBOR4_FINISHING_ROW = 34;
    public static final int HARBOR4_FINISHING_COLUMN = 186;



    // ISLAND 5 les deux pieds
    
    

    public static final int ISLAND5_STARTING_ROW = 50;
    public static final int ISLAND5_STARTING_COLUMN = 120;

    public static final int ISLAND5_FINISHING_ROW = 90;
    public static final int ISLAND5_FINISHING_COLUMN = 135;


    public static final int ISLAND5Point1_STARTING_ROW = 65;
    public static final int ISLAND5Point1_STARTING_COLUMN = 113;

    public static final int ISLAND5Point1_FINISHING_ROW = 50;
    public static final int ISLAND5Point1_FINISHING_COLUMN = 113;

    // HARBOR 5
    
    public static final String FEET = "FEET";

    public static final int HARBOR5_STARTING_ROW = 55;
    public static final int HARBOR5_STARTING_COLUMN = 123;

    public static final int HARBOR5_FINISHING_ROW = 56;
    public static final int HARBOR5_FINISHING_COLUMN = 126;



    // ISLAND 6 en bas milieu

    public static final int ISLAND6_STARTING_ROW = 80;
    public static final int ISLAND6_STARTING_COLUMN = 80;

    public static final int ISLAND6_FINISHING_ROW = 90;
    public static final int ISLAND6_FINISHING_COLUMN = 90;
    
    
    public static final int ISLAND6_POINT1_ROW[] = {87,88};
    public static final int ISLAND6_POINT1_COLUMN[]= {84,85,86,87,88,89,90,91};
    
    public static final int ISLAND6_POINT2_ROW[] = {81,82,83,84,87,88};
    public static final int ISLAND6_POINT2_COLUMN[]= {80,81};
    
    
    // HARBOR 6
    
    public static final String DEFORMED_SQUARE = "DEFORMED_SQUARE";

    public static final int HARBOR6_STARTING_ROW = 83;
    public static final int HARBOR6_STARTING_COLUMN = 82;

    public static final int HARBOR6_FINISHING_ROW = 85;
    public static final int HARBOR6_FINISHING_COLUMN = 85;
    
    
    
    
    
    
    // ISLAND 7 hourglass
  
    
    
    
    // TOP2BOT SIDE
    

    
    public static final int ISLAND7_BPOINT000_ROW[] = {16};
    public static final int ISLAND7_BPOINT000_COLUMN[]= {112,113,114,115,116,117,118,119,120,121,122,123,124};
    
    public static final int ISLAND7_BPOINT00_ROW[] = {17};
    public static final int ISLAND7_BPOINT00_COLUMN[]= {113,114,115,116,117,118,119,120,121,122,123};
    
    public static final int ISLAND7_BPOINT0_ROW[] = {18};
    public static final int ISLAND7_BPOINT0_COLUMN[]= {114,115,116,117,118,119,120,121,122};
    
    public static final int ISLAND7_BPOINT1_ROW[] = {19};
    public static final int ISLAND7_BPOINT1_COLUMN[]= {115,116,117,118,119,120,121};
    
    public static final int ISLAND7_BPOINT2_ROW[] = {20};
    public static final int ISLAND7_BPOINT2_COLUMN[]= {116,117,118,119,120};
    
    
    public static final int ISLAND7_BPOINT3_ROW[] = {21};
    public static final int ISLAND7_BPOINT3_COLUMN[]= {117,118,119};
 
    
    
    
    
    
    
    // BOT2TOP SIDE
    
    
   
    
    public static final int ISLAND7_TPOINT3_ROW[] = {22};
    public static final int ISLAND7_TPOINT3_COLUMN[]= {118};
    
    public static final int ISLAND7_TPOINT2_ROW[] = {23};
    public static final int ISLAND7_TPOINT2_COLUMN[]= {117,118,119};
    
    public static final int ISLAND7_TPOINT1_ROW[] = {24};
    public static final int ISLAND7_TPOINT1_COLUMN[]= {116,117,118,119,120};
    
    public static final int ISLAND7_TPOINT4_ROW[] = {25};
    public static final int ISLAND7_TPOINT4_COLUMN[]= {115,116,117,118,119,120,121};
    
    
    public static final int ISLAND7_TPOINT5_ROW[] = {26};
    public static final int ISLAND7_TPOINT5_COLUMN[]= {114,115,116,117,118,119,120,121,122};
    
    
    public static final int ISLAND7_TPOINT6_ROW[] = {27};
    public static final int ISLAND7_TPOINT6_COLUMN[]= {113,114,115,116,117,118,119,120,121,122,123};
    
    
    public static final int ISLAND7_TPOINT7_ROW[] = {28};
    public static final int ISLAND7_TPOINT7_COLUMN[]= {112,113,114,115,116,117,118,119,120,121,122,123,124};
    

    //HARBOR 7
    
    public static final String HOURGLASS = "HOURGLASS";
    
    
    public static final int HARBOR7_STARTING_ROW = 28;
    public static final int HARBOR7_STARTING_COLUMN = 117;

    public static final int HARBOR7_FINISHING_ROW = 29;
    public static final int HARBOR7_FINISHING_COLUMN = 120;
    

    
    
    
    
    // ISLAND 8 compass
    
    
    public static final int ISLAND8_ROW[] = {6,7,8,9,10,11,12};
    public static final int ISLAND8_COLUMN[]= {175,176,177,178,179,180,181};
    
    // LEFT SIDE
    
    public static final int ISLAND8_LPOINT1_ROW[] = {7,8,9,10,11};
    public static final int ISLAND8_LPOINT1_COLUMN[]= {174};
    
    public static final int ISLAND8_LPOINT2_ROW[] = {8,9,10};
    public static final int ISLAND8_LPOINT2_COLUMN[]= {173};
    
    public static final int ISLAND8_LPOINT3_ROW[] = {9};
    public static final int ISLAND8_LPOINT3_COLUMN[]= {172};
    
    public static final int ISLAND8_LPOINT4_ROW[] = {9};
    public static final int ISLAND8_LPOINT4_COLUMN[]= {172,175,176,177};
    
    
    // TOP SIDE
    
  
    public static final int ISLAND8_TPOINT1_ROW[] = {5};
    public static final int ISLAND8_TPOINT1_COLUMN[]= {176,177,178,179,180};
    
    
    public static final int ISLAND8_TPOINT2_ROW[] = {4};
    public static final int ISLAND8_TPOINT2_COLUMN[]= {177,178,179};
    
    public static final int ISLAND8_TPOINT3_ROW[] = {3};
    public static final int ISLAND8_TPOINT3_COLUMN[]= {178};
    
    
    public static final int ISLAND8_TPOINT4_ROW[] = {3,6,7,8};
    public static final int ISLAND8_TPOINT4_COLUMN[]= {178};
    
    
    // RIGHT SIDE  
    
    public static final int ISLAND8_RPOINT1_ROW[] = {7,8,9,10,11};
    public static final int ISLAND8_RPOINT1_COLUMN[]= {182};
    
    public static final int ISLAND8_RPOINT2_ROW[] = {8,9,10};
    public static final int ISLAND8_RPOINT2_COLUMN[]= {183};
    
    public static final int ISLAND8_RPOINT3_ROW[] = {9};
    public static final int ISLAND8_RPOINT3_COLUMN[]= {184};
    
    public static final int ISLAND8_RPOINT4_ROW[] = {9};
    public static final int ISLAND8_RPOINT4_COLUMN[]= {179,180,181,184};
    
    
    
    // BOTTOM SIDE
    
    
    
    public static final int ISLAND8_BPOINT1_ROW[] = {13};
    public static final int ISLAND8_BPOINT1_COLUMN[]= {176,177,178,179,180};
    
    
    public static final int ISLAND8_BPOINT2_ROW[] = {14};
    public static final int ISLAND8_BPOINT2_COLUMN[]= {177,178,179};
    
    public static final int ISLAND8_BPOINT3_ROW[] = {15};
    public static final int ISLAND8_BPOINT3_COLUMN[]= {178};
    
    public static final int ISLAND8_BPOINT4_ROW[] = {10,11,12,15};
    public static final int ISLAND8_BPOINT4_COLUMN[]= {178};
    
    
    
    
    // HARBOR 8
    
    public static final String COMPASS = "COMPASS";
    
    
    public static final int HARBOR8_STARTING_ROW = 9;
    public static final int HARBOR8_STARTING_COLUMN = 178;

    public static final int HARBOR8_FINISHING_ROW = 10;
    public static final int HARBOR8_FINISHING_COLUMN = 179;



    //SEAWAYS :
    public static final int SEAWAY_COUNT = 7;

    //seaway H1 -> H2


    //Continent
    public static final int SEAWAY_ID1 = 2;
    public static final int [] SEAWAY1_ROWS =    {16,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,95,95};
    public static final int [] SEAWAY1_COLUMNS = {10,11,12,13,14,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,14,13,12,11,10};


    // Ile marteau
    public static final int SEAWAY_ID2 = 3;
    public static final int [] SEAWAY2_ROWS =    {16,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,55,55,55,55,55,55,55,55,55,55,55,55,55,55,55,55,55,55,55,55,55,55,55,55,55,55,55};
    public static final int [] SEAWAY2_COLUMNS = {10,11,12,13,14,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43};


    // Ile Sablier
    public static final int SEAWAY_ID3 = 7;
    public static final int [] SEAWAY3_ROWS = 	 {16,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,29};
    public static final int [] SEAWAY3_COLUMNS = {10,11,12,13,14,15,15,15,15,15,15,15,15,15,15,15,15,15,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,117};



    // carr�
    public static final int SEAWAY_ID4 = 6;
    public static final int [] SEAWAY4_ROWS =    {16,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,86,85};
    public static final int [] SEAWAY4_COLUMNS = {10,11,12,13,14,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82};


    // Ile deux pieds
    public static final int SEAWAY_ID5 = 5;
    public static final int [] SEAWAY5_ROWS = 	 {16,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,65,64,63,62,61,60,59,58,57};
    public static final int [] SEAWAY5_COLUMNS = {10,11,12,13,14,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,117,118,119,120,121,122,123,123,123,124,124,124,124,124};


    // Ile boussole
    public static final int SEAWAY_ID6 = 8;
    public static final int [] SEAWAY6_ROWS = 	 {16,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,32,31,30,29,28,27,26,25,24,23,22,21,20,20,20,20,20,20,20,20,19,18,17,16,15,14,13,12,11};
    public static final int [] SEAWAY6_COLUMNS = {10,11,12,13,14,15,15,15,15,15,15,15,15,15,15,15,15,15,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,127,128,129,130,131,132,133,134,135,136,137,138,139,140,141,142,143,144,145,146,147,148,149,150,151,152,153,154,155,156,157,158,159,160,161,162,163,164,165,166,167,168,169,170,171,172,173,174,175,176,177};


    // Ile triangle
    public static final int SEAWAY_ID7 = 4;
    public static final int [] SEAWAY7_ROWS = 	 {16,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,34,35,36,37,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,38,37,36,35,34,33};
    public static final int [] SEAWAY7_COLUMNS = {10,11,12,13,14,15,15,15,15,15,15,15,15,15,15,15,15,15,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,127,128,129,130,131,132,133,134,135,136,137,138,139,140,141,142,143,144,145,146,147,148,149,150,151,152,153,154,155,156,157,158,159,160,161,162,163,164,165,166,167,168,169,170,171,172,173,174,175,176,177,178,179,180,181,182,183,184,185,186,187,187,187,187,187,187};




    //FLEET NAMES

    public static final int FLEET_ONE = 1;
    public static final int FLEET_TWO = 2;
    public static final int FLEET_COUNT = 2;


    public static final String COFFEE = "Cafe";
    public static final String SUGAR = "Sucre";
    public static final String SALT = "Sel";
    public static final String SPICES = "Epices";
    public static final String GOLD = "Or";
    public static final String COTTON = "Coton";
    public static final String SILK = "Soie";
    public static final String PAPER = "Papier";
    public static final String TISSUE = "Tissu";
    public static final String TOBACCO = "Tabac";

    public static final String[] RESOURCES = {COFFEE,SUGAR,COFFEE,SUGAR,SALT,SPICES,GOLD,COTTON,SILK,PAPER,TISSUE,TOBACCO};

    
    //RESOURCES PRICE
    
    public static final int PRICE_COFFEE = 60;
    public static final int PRICE_SUGAR = 70;
    public static final int PRICE_SALT = 50;
    public static final int PRICE_SPICES = 100;
    public static final int PRICE_GOLD = 1000;
    public static final int PRICE_COTTON = 70;
    public static final int PRICE_SILK = 200;
    public static final int PRICE_PAPER = 10;
    public static final int PRICE_TISSUE = 70;
    public static final int PRICE_TOBACCO = 200;
}
