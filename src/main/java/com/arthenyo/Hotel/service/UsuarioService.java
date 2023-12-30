package com.arthenyo.Hotel.service;

import com.arthenyo.Hotel.dto.AcessoDTO;
import com.arthenyo.Hotel.dto.UsuarioDTO;
import com.arthenyo.Hotel.dto.UsuarioSaveDTO;
import com.arthenyo.Hotel.model.Acesso;
import com.arthenyo.Hotel.model.Usuario;
import com.arthenyo.Hotel.projections.UserDetailsProjection;
import com.arthenyo.Hotel.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UsuarioService implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public UsuarioDTO save(UsuarioSaveDTO usuarioSaveDTO){
        Usuario entity = new Usuario();
        entitytoDto(entity,usuarioSaveDTO);
        entity.setSenha(passwordEncoder.encode(usuarioSaveDTO.getSenha()));
        entity = usuarioRepository.save(entity);
        return new UsuarioDTO(entity);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UserDetailsProjection> result = usuarioRepository.searchUserAndRolesByEmail(username);
        if(result.size() == 0){
            throw new UsernameNotFoundException("User not faund");
        }
        Usuario user = new Usuario();
        user.setEmail(username);
        user.setSenha(result.get(0).getPassword());

        for (UserDetailsProjection projection: result){
            user.addRole(new Acesso(projection.getRoleId(),projection.getAuthority()));
        }
        return user;
    }
    private void entitytoDto(Usuario entity, UsuarioSaveDTO dto){
        entity.setNome(dto.getNome());
        entity.setCpf(dto.getCpf());
        entity.setEmail(dto.getEmail());
        entity.setTelefone(dto.getTelefone());
        entity.setTipoUsuario(dto.getTipoUsuario());
        entity.getAcessos().clear();
        for(AcessoDTO acessoDTO : dto.getAcessos()){
            Acesso acesso = new Acesso();
            acesso.setId(acessoDTO.getId());
            entity.getAcessos().add(acesso);
        }
    }
}
