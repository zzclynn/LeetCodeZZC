public class IntersectionofTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthHeadA=0;
        int lengthHeadB=0;
        
        ListNode temp1=headA;
        ListNode temp2=headB;
        while(temp1 != null){
            temp1=temp1.next;
            lengthHeadA++;
        }
        while(temp2 != null){
            temp2=temp2.next;
            lengthHeadB++;
        }
        int length=Math.min(lengthHeadA,lengthHeadB);
        if(length==0){
            return null;
        }
        int unmatchedsize;

        if(lengthHeadA>lengthHeadB){
            unmatchedsize=lengthHeadA-lengthHeadB;
            while(unmatchedsize!=0){
                headA=headA.next;
                unmatchedsize--;
            }
            temp1=headA;
            temp2=headB;
        }
        else{
            unmatchedsize=lengthHeadB-lengthHeadA;
            while(unmatchedsize!=0){
                headB=headB.next;
                unmatchedsize--;
            }
            temp1=headB;
            temp2=headA;
        }
        
        while(length!=0){
            if(temp1==temp2){
                if(temp1==null){
                    return null;
                }
                return temp1;
            }
            temp1=temp1.next;
            temp2=temp2.next;
            length--;
        }
        return null;
	}
		
	public ListNode getIntersectionNodeBetter(ListNode headA, ListNode headB) {
        if( null==headA || null==headB )
            return null;

        ListNode curA = headA, curB = headB;
        while( curA!=curB){
            curA = curA==null?headB:curA.next;
            curB = curB==null?headA:curB.next;
        }
        return curA;
    }
	
	public static void main(String[] args) {
		int[] num=new int[]{1,2,3,4,5,5,4,3,4,6};
		System.out.println("result");
	}

}
