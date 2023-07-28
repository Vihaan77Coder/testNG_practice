package excel_utility;
public interface ExcelUtility 
// we have made ExcelUtility an interface not a class because we wanted to use abstraction.
// Methods of interface doesn't contain any body.
{
  public String getreaddata(int sheetno, int colno, int rowno);
}
