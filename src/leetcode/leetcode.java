package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class leetcode {
	public static String[] keyboard={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		String s="";
		ListNode result=new ListNode(0);
		ListNode a=new ListNode(1);
		ListNode b=new ListNode(2);
		ListNode c=new ListNode(3);
		ListNode d=new ListNode(4);
		ListNode e=new ListNode(5);
		ListNode f=new ListNode(6);
		a.next=b;
		b.next=c;
		c.next=d;
		//d.next=e;
		//e.next=f;
		int k=2;
		ListNode head=a;
		result=reverseKGroup(a,k);
		for(int i=0;i<4;i++)
		{
			System.out.println(result.val);
			result=result.next;
		}
	}
	public static ListNode reverseKGroup(ListNode head, int k) {
		ListNode result=head;
		ListNode lasthead=head;
		boolean first=true;
		while(true)
		{
			int n=k-1;
			head=lasthead;
			if(head==null)
				return result;
			while(n>0 && head.next!=null)
			{
				head=head.next;
				n--;
			}
			if(n>0 && first)//����Ҫ��ת
				return result;
			else if(n==0)//��Ҫ��ת
			{
				ListNode temp=head.next;
				ListNode temp2=lasthead.next;
				int num=k;
				while(num>0)
				{
					lasthead.next=temp;//reverse
					temp=lasthead;//next
					lasthead=temp2;
					if(temp2!=null)
						temp2=temp2.next;
					num--;
				}
				if(first)//��һ�μ�¼��󷵻صĽ��
					result=head;
				head=lasthead;
				//lasthead=temp2;
				first=false;
			}
			else//֮ǰ��ת�� ���һ�β���Ҫ��ת
			{
				return result;
			}
		}
    }
	public static class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) {
		 	val = x;
		 	next = null;
		 }
	}
}
