package twosvm.model.files;

import java.io.File;

public class RemoveFiles {

	public void removeFile(String path) {

		File file = null;
		boolean bool = false;

		try {
			// create new file
			file = new File(path);

			// tries to delete a non-existing file
			bool = file.delete();

			// prints
			System.out.println("File deleted: " + bool);

			// creates file in the system
			file.createNewFile();

			// tries to delete the newly created file
			bool = file.delete();

			// print
			System.out.println("File deleted: " + bool);

		} catch (Exception e) {
			// if any error occurs
			e.printStackTrace();
		}

	}

}
