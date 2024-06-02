package com.lwj.blog.test;

import java.util.function.Supplier;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lwj.blog.model.RoleType;
import com.lwj.blog.model.User;
import com.lwj.blog.repository.UserRepository;
@RestController
public class DummyControllerTest {
	@Autowired //의존성 주입
	private UserRepository userRepository;
	//id 주소로 파라미터를 전달받는다.
	@PostMapping("/dummy/join")
	public String join(User user) {
		System.out.println("id : " + user.getId());
		System.out.println("userName : " + user.getUserName());
		System.out.println("password : " + user.getPassword());
		System.out.println("email : " + user.getEmail());
		System.out.println("createDate : " + user.getCreateDate());
		
		user.setRole(RoleType.USER);
		
		userRepository.save(user); // 파라미터로 가져온 값이 insert된다. 
		return "회원가입이 완료되었습니다.";
		
	}
	//id 주소로 파라미터를 전달받는다.
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
		//user/4를 찾으면 내가 db에서 못찾을경우 user가 null이 될 수 있다.
		//return null이 되지 않기 위해 Optinal로 너의 user 객체를 감싸서 가져온다.
		//null or 비 null인지 아닌지 판단하여return한다.
		User user = userRepository.findById(id).orElseGet(new Supplier<User>() {
			@Override
			public User get() {//없는 id값이 들어오면 이 메소드를 따른다.
				return new User();//비어있는 User()객체를 넣어줌.
			}
		});
		//null이면 얘가 객체를 만듬
		return user;
		
	}
	@GetMapping("/dummy/user")
	public List<User> pageList(@PageableDefault(size=2, sort="id", direction= Sort.Direction.DESC) Pageable pageable){
		Page<User> users = userRepository.findAll(pageable);
		//분기 가능
		/*
		if(pagingUser.isFirst()) {
        // 첫번째 페이지 일 경우
    	}
    	if(pagingUser.isLast()) {
        // 마지막 페이지 일 경우
    	}
		 */
		//이걸통해 페이징 정보를 제외하고 출력 가능
		List<User> u = users.getContent();
		
		return u;
	}
	//http://localhost:8001/blog/dummy/users
	@GetMapping("/dummy/users")
	public List<User> getList(){
		return userRepository.findAll();
	}
	//람다식
	/*
	  @GetMapping("/dummy/user/{id}")
public User detail(@PathVariable int id) {
    User user = userRepository.findById(id).orElseThrow(()->{
        return new IllegalArgumentException("해당 사용자는 없습니다. id : " + id);
    })
    return user;
}
	 */
	/*
	 * 근데 data를 리턴해주는 @RestController를 사용했고 반환값으로 return user; 을 했는데 어떻게 결과 값이 JSON 형식으로 나왔을까 ?
 

		요청 : 웹 브러우저 user 객체 = 자바 오브젝트
		변환 해야된다. (웹 브라우저가 이해할 수 있는 데이터) -> json (Gson 라이브러리)

	
		하지만 스프링부트에서는 MessageConverter라는 애가 응답시에 자동으로 동작하게 된다.
		만약에 자바 오브젝트를 리턴하게 되면 MessageConverter가 Jackson 라이브러리를 호출해서 User 오브젝트를 json으로 변환해서 브라우저에게 던져준다. 즉 자동으로 변환 시켜준다. 매우 편리함

 

		크롬 개발자도구에서 확인결과 content-Type이 json 형식인것을 알 수 있다.
	 */
	
	//비밀번호 이메일 변경 메소드
	@PutMapping("/dummy/user/{id}")
	public User updateUser(@PathVariable int id, @RequestBody User requestUser) {
		//test
		System.out.println("id :" + id);
		System.out.println("pw :" + requestUser.getPassword());
		System.out.println("email :" + requestUser.getEmail());
		
	    User user = userRepository.findById(id).orElseThrow(()->{ // id가 1인 유저의 정보
	        return new IllegalArgumentException("수정에 실패했습니다.");
	    });
	    user.setPassword(requestUser.getPassword());
	    user.setEmail(requestUser.getEmail());
		userRepository.save(user);
		
		return null;
	}
}
