import java.util.ArrayList;

public class Graph <E>{

    private ArrayList<ArrayList<E>> data;

    //default constructor
    public Graph(){
        this.data = new ArrayList<ArrayList<E>>();
    }

    //a method to add to the graph
    public void addVertex(E ver) throws VertexExistException{
        int i = 0;
        //a loop to check if already exist and throws exception if needed
        while (i < data.size()){
            if (ver == data.get(i).get(0))
                throw new VertexExistException("Vertex Exist");
            i++;
        }
        //if not exist adding it to the end
        data.add(new ArrayList<>());
        data.get(data.size() - 1).add(ver);
    }

    //a method to add connection between to variables
    public void addEdge(E ver1, E ver2) throws VertexNotExistException{
        //a boolean that chances if we found what we were looking for
        boolean isVer1 = false, isVer2 = false;
        //two variables that save the index of what we need to connect
        int indexVer1 = 0;
        int indexVer2 = 0;
        //looping to find the required variables
        for (int i = 0; i < data.size(); i++) {
            if (ver1 == data.get(i).get(0)) {
                indexVer1 = i;
                isVer1 = true;
            }
            if (ver2 == data.get(i).get(0)) {
                indexVer2 = i;
                isVer2 = true;
            }
        }
        //if one of the variables wasn't found we throw an exception
        if (!isVer1 || !isVer2)
            throw new VertexNotExistException("Vertex doesn't Exist");
        //adding the connection both ways
        else {
            data.get(indexVer1).add(ver2);
            data.get(indexVer2).add(ver1);
        }
    }

    //a method that returns all the connections
    public ArrayList<E> getEdges(E ver) throws VertexNotExistException{
        //a boolean that chances if we found what we were looking for
        boolean isVer = false;
        //a variable that saves the index of what we are looking for
        int indexVer = 0;
        //a new list to store all the info
        ArrayList<E> returnedList = new ArrayList<>();
        //looping the graph to find the variable we want
        for (int i = 0; i < data.size(); i++){
            if (ver == data.get(i).get(0)){
                indexVer = i;
                isVer = true;
            }
        }
        //if we didn't find it we throw an exception
        if (!isVer)
            throw new VertexNotExistException("Vertex doesn't Exist");
        else {
            //if there aren't any connection we return an empty list
            if (data.get(indexVer).size() <= 0)
                return new ArrayList<>();
            //looping throw the connections and adding them to the new list
            for (int j = 1; j < data.get(indexVer).size(); j++)
                returnedList.add(data.get(indexVer).get(j));
            return returnedList;
        }
    }

    //a method that return all the nods
    public ArrayList<E> getVertices(){
        //a new list to store all the info
        ArrayList<E> returnedList = new ArrayList<>();
        //if the graph is empty we return an empty list
        if (data.size() <= 0)
            return new ArrayList<>();
        //looping through and graph and adding the nods to the new list
        for (int i = 0; i < data.size(); i++)
            returnedList.add(data.get(i).get(0));
        return returnedList;
    }

    //a method to find if there is a connection
    public ArrayList<E> bfs(E from, E to) {
        //using the recursive method
        return checkBFS(from, to, new ArrayList<>());
    }

    //a recursive method to the if there is a connection
    public ArrayList<E> checkBFS(E from, E to, ArrayList<E> friends) {
        //adding the first step
        friends.add(from);
        //if we found it we return the list
        if (friends.get(friends.size() - 1) == to)
            return friends;
        try {
            //looping to see if there is a path to follow
            for (E friend : getEdges(from)) {
                //a boolean that changes if we found what we were looking for
                boolean flag = false;
                //looping to see if there aren't any doubles
                for (E i : friends) {
                    if (i == friend) {
                        flag = true;
                        break;
                    }
                }
                if (!flag){
                    //calling the recursive method to continue down the path
                    ArrayList<E> match = checkBFS(friend, to, friends);
                    //if we got to the result we return it
                    if (friends.get(friends.size() - 1) == to) {
                        return match;
                    }
                    //removing what we don't need
                    friends.remove(friend);
                }
            }
        }
        //if there is no path we return an empty list
        catch (VertexNotExistException e) {
            return new ArrayList<>();
        }
        return new ArrayList<>();
    }

    //a method to check if the users exist
    public boolean checkIfExist(E ver){
        //looping to see if we get a match
        for (int i = 0; i < data.size(); i++) {
            if (ver == data.get(i).get(0))
                return true;
        }
        return false;
    }
}