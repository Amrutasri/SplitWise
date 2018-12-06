import java.util.List;

class Trip {

    private List<Friend> friendList;

    Trip(List<Friend> friendList) {
        this.friendList = friendList;
    }

    List<Friend> getFriendList() {
        return friendList;
    }
}
