package br.com.alura.forum.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.alura.forum.modelo.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.bytebuddy.asm.Advice.This;

@Service
public class TokenService {

	//Pegando nas variaveis de ambiente,
	//No arquivo application.properties
	
	@Value("${forum.jwt.expiration}")
	private String expiration;
	
	@Value("${forum.jwt.secret}")
	private String secret;
	
	//Aqui vamos criar TOKEN
	//Vamos ussar o JWTS
	public String gerarToken(Authentication authentication) {
		
		//Pega o USER autenticado e taca na nossa Classe Usuario
		Usuario logado = (Usuario)authentication.getPrincipal();
		
		//Pega a data do dia que vai gerar o TOKEN
		Date hoje = new Date();
		
		//Pega a data do token e adiciona um dia para expirar
		Date expiracao = new Date(hoje.getTime() + Long.parseLong(expiration));
		
		return Jwts.builder()
				.setIssuer("API do Fórum dA Alura") //Nome do criador do token
				.setSubject(logado.getId().toString())  //Pega um campo unico do usuario logado e passa para string
				.setIssuedAt(hoje) //Precisa da data de criação do token
				.setExpiration(expiracao) //Data que o token vai expirar
				.signWith(SignatureAlgorithm.HS256, secret) //Encriptografar com algoritmo + senha
				.compact(); //Compacta tudo em String
	}

	public boolean isTokenValido(String token) {
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public Long getIdUsuario(String token) {
		Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		return Long.parseLong(claims.getSubject());

	}

}
