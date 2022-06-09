package carolinacota.boardgames.readFile

import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.File
import java.io.FileInputStream


class ReadFile(
    val filePath: String,
) {
    fun call() = List<BoardGame>(7) { parseFile(it+1) }

    private fun parseFile(row: Int) : BoardGame {
        val sheet = getSheet()
        val id = sheet.getRow(row).getCell(0).numericCellValue.toInt().toString()
        val name = sheet.getRow(row).getCell(1).toString()
        return BoardGame(id, name)
    }

    private fun getSheet() : XSSFSheet {
        val file = File(filePath)
        val inputStream = FileInputStream(file)
        val workBook = XSSFWorkbook(inputStream)
        return workBook.getSheetAt(0)
    }

    private fun getRowsCount() = getSheet().lastRowNum
}