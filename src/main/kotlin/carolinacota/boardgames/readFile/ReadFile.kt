package carolinacota.boardgames.readFile

import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.ss.usermodel.WorkbookFactory
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.File
import java.io.FileInputStream


class ReadFile(
    val filePath: String,
) {
    fun call() = List<BoardGame>(7) { parseFile(it) }


    private fun parseFile(row: Int) : BoardGame {
        val file = File(filePath)
        val inputStream = FileInputStream(file)
        val workBook = XSSFWorkbook(inputStream)
        val sheet = workBook.getSheetAt(0)
        val id = sheet.getRow(row+1).getCell(0).numericCellValue.toInt().toString()
        val name = sheet.getRow(row + 1).getCell(1).toString()
        return BoardGame(id, name)
    }
}