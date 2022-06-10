package carolinacota.boardgames.readFile

import org.apache.poi.xssf.usermodel.XSSFCell
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.File
import java.io.FileInputStream


class ReadFile(
    private val filePath: String,
) {
    fun call() = List<BoardGame>(rowsCount) { parseFile(it + 1) }

    private fun parseFile(row: Int): BoardGame {
        val id = cell(row, 0).toIntCell().toString()
        val name = cell(row, 1).toString()
        val yearPublished = cell(row, 2).toString()
        val minPlayers = cell(row, 3).toIntCell()
        val maxPlayers = cell(row, 4).toIntCell()
        val playTime = cell(row, 5).toIntCell()
        val minAge = cell(row, 6).toIntCell()
        val numberOfRatings = cell(row, 7).toIntCell()
        val ratingAverage = cell(row, 8).toDoubleCell()
        val bggRank = cell(row, 9).toIntCell()
        val complexityAverage = cell(row, 10).toDouble2DigitCell()
        val ownedGames = cell(row, 11).toIntCell()
        val mechanics = cell(row, 12).toString()
        val domains = cell(row, 13).toString()
        return BoardGame(
            id,
            name,
            yearPublished,
            minPlayers,
            maxPlayers,
            playTime,
            minAge,
            numberOfRatings,
            ratingAverage,
            bggRank,
            complexityAverage,
            ownedGames,
            mechanics,
            domains
        )
    }

    private fun getSheet(): XSSFSheet {
        val file = File(filePath)
        val inputStream = FileInputStream(file)
        val workBook = XSSFWorkbook(inputStream)
        return workBook.getSheetAt(0)
    }

    private val rowsCount = getSheet().lastRowNum

    private fun cell(row: Int, num: Int) = getSheet().getRow(row).getCell(num)

    private fun XSSFCell.toIntCell() = numericCellValue.toInt()

    private fun XSSFCell.toDoubleCell() = numericCellValue

    private fun XSSFCell.toDouble2DigitCell() = "%.2f".format(numericCellValue).toDouble()

    private val titleMapping = mapOf(
        "id" to 0,
        "name" to 1,
        "yearPublished" to 2,
        "minPlayers" to 3,
        "maxPlayers" to 4,
        "playTime" to 5,
        "minAge" to 6,
        "numberOfRatings" to 7,
        "ratingAverage" to 8,
        "bggRank" to 9,
        "complexityAverage" to 10,
        "ownedGames" to 11,
        "mechanics" to 12,
        "domains" to 13
    )
}