package pr1.uebung10;

public class ListNode {
    
    private ListNode next;
    private Song value;

    public ListNode() {
        next = null;
    }
    
    public ListNode getNext() {
        return next;
    }
    public void setNext(ListNode next) {
        this.next = next;
    }
    
    public void setValue(Song song) {
        this.value = song;
    }
    public Song getValue(){
    	return value;
    }

}

//public class ListNode implements Comparable<ListNode>{
//	private SongImplementation song;
//	private ListNode next;
//	
//	public ListNode(SongImplementation song){
//		this.song = song;
//		next = null;
//		
//	}
//	public ListNode getNext() {
//		return next;
//	}
//	public void setNext(ListNode next){
//		this.next = next;
//	}
//	@Override
//	public int compareTo(ListNode o) {
//		return this.song.compareTo(o.getSong());
//	}
//	public SongImplementation getSong(){
//		return this.song;
//	}
//	public void placeSongInfront(SongImplementation song){
//		SongImplementation oldHead = this.song;
//		while(this.next != null){
//			this.song = song;
//			this.next.placeSongInfront(oldHead);
//		}
//		if(this.next == null){
//			this.next = new ListNode(oldHead);
//		}
//	}
//	public void placeSongAfter(ListNode song){
//		this.next = song;
//	}
//
//}
