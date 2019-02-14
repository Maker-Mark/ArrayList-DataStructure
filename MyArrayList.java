import java.util.*;
import java.io.*;
/* TODO:
   -need and array

*/
public class MyArrayList<E> {
  
  private E[] arr;
  private int numElem; // static makes things oblivious
    // a private class that the user does not know about!
  private class OurArrayIterator implements Iterator<E>{
  private int index;
    public OurArrayIterator(){
    index = 0;}
    public boolean hasNext(){
    return index < numElem;
    }
    public E next(){
    index++;
      return get(index-1);  
    }
    public void remove(){
      //optional, call remove on index-1
       MyArrayList.this.remove(index-1);
      // go to my outer scope and remve
    }
  
  }
    
  public MyArrayList(){
      numElem=0;
    // Casting happens at runtime 
    // Trying to downcast, but we need a work around
    arr = (E[]) new Object[20];// Making a default size  
      // untilk runtime JAVA does not know  what type E is
  }
  
  public boolean add(E e){
    if(numElem == arr.length)
      grow();
  arr[numElem] = e;
    numElem++;
    return true;
  
  
  }
  
//   public boolean (E e){
//    if(numElements == arr.length)
//        grow();
//     for(int i = numElem-1;i >= index; i--)
//       arr[i+i] = arr[i];// the one to the right of i is now equal to the ith positon
    
//     arr[index] = value;// now that we have the slotm
//     numElem++;
  
  
//   }
  
  private void grow(){
    
  E[] temp = (E[]) new Object[2*arr.length];
    for(int i = 0; i<arr.length;i++)
    temp[i] = arr[i];
              
      arr = temp;
            }
              
              
              
  public int size(){
  return numElem;
  }
  public boolean empty(){
  return numElem == 0;}
              
public Iterator<E> iterator(){
return new OurArrayIterator();
}
              
  public boolean remove(Object obj){
  int index = indexOf(obj);
    if(index ==-1)
      return false;
    remove(index);
  return true;
  
  }
              
  public void remove(int index){
  E value = arr[index];
    for(int i = index+1; i<numElem; i++)
      arr[i-1] = arr[i];
    numElem--;
  }
              
  public E get(int index ) {
  // if( index >= numElem || index <0)
  //   throw new Exception();
    return arr[index];
  }
  public E set(int index, E value) throws Exception{
     if( index >= numElem || index <0)
    throw new Exception();
  E old = arr[index];
    arr[index] = value;
      return old;
  
  }
  public void clear (){
  numElem = 0;
  
  }
  public boolean contains(Object obj) {// uses indexof, if its not negative 1, the {
    return indexOf(obj)!=-1;
      }
              
  // public boolean equals(Object obj);
              
  public int indexOf(Object obj){
  for(int i =0; i<numElem; i++)
      if(arr[i].equals(obj))
        return i;
    return -1;
  }
  public String toString(){
  String result = ""; // can use string builder
    // for(E f : this)
    for(int i=0; i <numElem; i++)
      result += arr[i]+ " ";
    return result;
  }
              
              
              
  public  static void main(String[] args){
                MyArrayList<E> list;
                list = new MyArrayList<E>();
                System.out.print(list);
              
              }
  
  
}
            

