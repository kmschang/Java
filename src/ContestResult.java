public class ContestResult {

    private String winner = "";
    private String secondPlace = "";
    private String thirdPlace = "";



    public void setWinner(String winner){
        this.winner = winner;
    }
    public void setSecondPlace(String secondPlace){
        this.secondPlace = secondPlace;
    }
    public void setThirdPlace(String thirdPlace){
        this.thirdPlace = thirdPlace;
    }


    public String getWinner(){
        return winner;
    }
    public  String getSecondPlace(){
        return secondPlace;
    }
    public String getThirdPlace(){
        return thirdPlace;
    }


}
