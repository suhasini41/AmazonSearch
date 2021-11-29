package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TiemStamp
{
	public static String timestamp()
	{
		String timeStamp = new SimpleDateFormat("mm-dd-yyyy").format(new Date());
		return timeStamp;
	}

}
