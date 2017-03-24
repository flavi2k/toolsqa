Sub x_fotbal_fara_pauza()
Worksheets("Sheet1").Activate

noRows = 11

Range("L2:Q15").NumberFormat = "@"

For i = 2 To noRows
allData = Range("A" & i)
echipa1 = Split(allData, " - ")(0)
echipa2 = Split(Split(allData, " - ")(1), ",")(0)
rezultatFinal = Split(allData, ", ")(1)
dataMeci = Split(allData, ", ")(2)
campionat = Split(allData, ", ")(3)
rezultatFinalGazde = "=Left(P" & i & ",1)"
rezultatFinalOaspeti = "=Right(P" & i & ",1)"


Cells(i, 12) = dataMeci
Cells(i, 13) = echipa1
Cells(i, 14) = echipa2
Cells(i, 15) = ""
Cells(i, 16) = rezultatFinal
Cells(i, 17) = campionat
Cells(i, 21) = rezultatFinalGazde
Cells(i, 22) = rezultatFinalOaspeti


If (Cells(i, 21) = Cells(i, 22)) Then
rezultat = "X"

Else
If (Cells(i, 21) > Cells(i, 22)) Then
rezultat = "1"

Else
rezultat = "2"
End If
End If

Cells(i, 23) = rezultat
Next i

For i = 2 To noRows

If (StrComp((Cells(i, 23)), Cells(i + 1, 23))) = 0 Then
If (StrComp(Cells(i, 23), Cells(i + 2, 23))) = 0 Then

Cells(i, 23).Interior.ColorIndex = 4
Cells(i + 1, 23).Interior.ColorIndex = 4
Cells(i + 2, 23).Interior.ColorIndex = 4
End If

End If
Next i

End Sub
Sub x_fotbal()
Worksheets("Sheet1").Activate

Range("L2:Q15").NumberFormat = "@"

For i = 2 To 15
allData = Range("A" & i)
echipa1 = Split(allData, " - ")(0)
echipa2 = Split(Split(allData, " - ")(1), ",")(0)
scoreAll = Split(allData, ", ")(1)
rezultatFinal = Split(scoreAll, " (")(0)
rezultatPauza = Split(Split(scoreAll, " (")(1), ")")(0)
dataMeci = Split(allData, ", ")(2)
campionat = Split(allData, ", ")(3)



Cells(i, 12) = dataMeci
Cells(i, 13) = echipa1
Cells(i, 14) = echipa2
Cells(i, 16) = rezultatFinal
Cells(i, 15) = rezultatPauza
Cells(i, 17) = campionat

Next i

End Sub