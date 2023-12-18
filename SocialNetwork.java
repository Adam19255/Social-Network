import java.util.ArrayList;

public class SocialNetwork {

    private Graph<String> network;

    //default constructor
    public SocialNetwork(){
        this.network = new Graph<>();
    }

    //a method to add a new user
    public void addUser(String user) throws UserExistException{
        try{
            //calling the required method for the job
            network.addVertex(user);
        }
        //if user exist we throw an exception
        catch (VertexExistException e){
            throw new UserExistException ("User Exist");
        }
    }

    //a method to add a friend
    public void addFriends(String user1, String user2) throws UserNotFoundException{
        try{
            //calling the required method for the job
            network.addEdge(user1, user2);
        }
        //if one of the users doesn't exist we throw an exception
        catch (VertexNotExistException e){
            throw new UserNotFoundException("User Not Found");
        }
    }

    //a method to see if users know each other
    public boolean knows(String user1, String user2) throws UserNotFoundException{
        //checking if the users provided exist and throwing an exception if false
        if (!network.checkIfExist(user1) || !network.checkIfExist(user2))
            throw new UserNotFoundException("User not Found");
        ////calling the required method for the job
        if (network.bfs(user1, user2).size() <= 0)
            return false;
        return true;
    }
}