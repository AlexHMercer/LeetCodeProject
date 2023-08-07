package com.leetcode.copyrandomlist;

import java.util.HashMap;

/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
 * 还有一个 random 指针指向链表中的任意节点或者 null。
 * 本题本质是深拷贝
 * 分析：
 *      因为链表的节点不止一个next还有一个random，所以直接遍历时会出现指向的节点还未创建的情况
 *      解决：
 *          构建一个map，key存放已存在的节点，value存放构建的新的对应节点
 *          则遍历链表，将每个节点及对应的新节点放到map里，新节点的next和random则递归产生
 *      法2：（待实现）
 *      可以在链表的每个节点之后构建一个新的节点，新节点与原节点一一对应，
 *      为新节点添加next和random时，根据原节点的next和random赋值，减少空间消耗。
 */
public class CopyRandomList {
    HashMap<Node,Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null){
            return head;
        }
        if(!map.containsKey(head)){
            Node tempNode = new Node(head.val);
            map.put(head,tempNode);
            tempNode.next = copyRandomList(head.next);
            tempNode.random = copyRandomList(head.random);
        }
        return map.get(head);
    }
}
