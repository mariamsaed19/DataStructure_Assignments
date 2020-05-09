package mailServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

import eg.edu.alexu.csd.datastructure.linkedList.cs76_cs88.DoublyLinkedList;
import eg.edu.alexu.csd.datastructure.queue.Queue;

public class main { 

	public static void main(String[] args) throws IOException  {
		App a = new App();
		Contact me = new Contact();
		Mail m = new Mail ();
		Sort sort = new Sort();
		Folder folder = new Folder();
		Filter filter = new Filter();
		//folder.setMail("mera@yahoo.com");
		folder.setFolderName("inbox");
		//sort.settype("subject");
		//folder.readIndex();
		//a.set.folder=folder;
		//a.set.sort=sort;
		//folder.getSubject();
		DoublyLinkedList x = new DoublyLinkedList();
		x.add("src\\contacts\\mera@yahoo.com\\sent\\1");
		x.add("src\\contacts\\mera@yahoo.com\\sent\\2");
		a.moveEmails(x, folder);
		System.out.println("end");

}
}
