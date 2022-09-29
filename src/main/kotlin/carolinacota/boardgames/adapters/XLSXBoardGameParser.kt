package carolinacota.boardgames.adapters

import carolinacota.boardgames.domain.BoardGame
import carolinacota.boardgames.domain.BoardGameParser
import org.apache.poi.ss.usermodel.WorkbookFactory
import org.apache.poi.xssf.usermodel.XSSFCell
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.io.FileInputStream

@Service
class XLSXBoardGameParser(
    @Value("\${boardGame.data}")
    private val filePath: String,
) : BoardGameParser {
    override fun call(): List<BoardGame> {
        val sheet = getSheet()
        return List<BoardGame>(sheet.lastRowNum) { sheet.parseRow(it + 1) }
    }

    private fun getSheet(): XSSFSheet {
        val inputStream = FileInputStream(filePath)
        //Instantiate Excel workbook using existing file:
        var xlWb = WorkbookFactory.create(inputStream)

        inputStream.close()
        return xlWb.getSheetAt(0) as XSSFSheet
    }

    private fun XSSFSheet.parseRow(row: Int): BoardGame {
        val id = getRow(row).getCell(0).toIntCell().toString()
        val name = getRow(row).getCell(1).toString()
        val numberOfRatings = getRow(row).getCell(7).toIntCell()
        val ratingAverage = getRow(row).getCell(8).toDoubleCell()
        return BoardGame(
            id,
            name,
            numberOfRatings,
            ratingAverage
        )
    }

    private fun XSSFCell.toIntCell() = numericCellValue.toInt()

    private fun XSSFCell.toDoubleCell() = numericCellValue
}