package hu.corvinus.negyedik.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class SignInData {
    private String name;
    private String username;
    private int pw;
}
