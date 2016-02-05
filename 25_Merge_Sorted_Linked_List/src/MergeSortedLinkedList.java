
public class MergeSortedLinkedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode temp=new ListNode(-1);
        ListNode result=temp;

        while(l1!=null||l2!=null){
            if(l1==null){
                result.next=new ListNode(l2.val);
                l2=l2.next;
            }else if(l2==null){
                result.next=new ListNode(l1.val);
                l1=l1.next;   
            }else{
                if(l1.val<l2.val){
                    result.next=new ListNode(l1.val);
                    l1=l1.next;
                    
                }else{
                    result.next=new ListNode(l2.val);
                    l2=l2.next;
                }
            }
            result=result.next;
        }
        return temp.next;
    }

}
