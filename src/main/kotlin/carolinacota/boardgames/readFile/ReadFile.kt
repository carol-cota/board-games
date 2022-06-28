package carolinacota.boardgames.readFile

import org.apache.poi.xssf.usermodel.XSSFCell
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.io.File
import java.io.FileInputStream

@Service
class ReadFile(
    @Value("\${boardGame.data}")
    private val filePath: String,
) {
    fun call() = List<BoardGame>(getSheet().lastRowNum) { parseFile(it + 1) }

    private fun parseFile(row: Int): BoardGame {
        val id = cell(row, 0).toIntCell().toString()
        val name = cell(row, 1).toString()
        val numberOfRatings = cell(row, 7).toIntCell()
        val ratingAverage = cell(row, 8).toDoubleCell()
        return BoardGame(
            id,
            name,
            numberOfRatings,
            ratingAverage
        )
    }

    private fun getSheet(): XSSFSheet {
        val file = File(filePath)
        val inputStream = FileInputStream(file)
        val workBook = XSSFWorkbook(inputStream)
        return workBook.getSheetAt(0)
    }

    private fun cell(row: Int, num: Int) = getSheet().getRow(row).getCell(num)

    private fun XSSFCell.toIntCell() = numericCellValue.toInt()

    private fun XSSFCell.toDoubleCell() = numericCellValue
}