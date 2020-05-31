program circle
    INTEGER A,B

    if ( A .le. B) THEN
        if( B .eqv. 2) THEN
            A = 2
        elseif( A .ge. B) THEN
            B = 2
        end if
    else
        B = 2
    end if
end