
public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode fast=dummy;
        ListNode slow=dummy;
        int temp=n;
        for(;fast.next!=null;temp--){
            if(temp<=0){ //control
                slow=slow.next;
            }
            fast=fast.next;
        }
        slow.next=slow.next.next;//delete Nth
        return dummy.next;
    }
    
}
